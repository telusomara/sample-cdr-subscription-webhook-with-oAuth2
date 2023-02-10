package com.omara.smilecdr.demo.subscription;

import ca.uhn.fhir.interceptor.api.Hook;
import ca.uhn.fhir.interceptor.api.Interceptor;
import ca.uhn.fhir.interceptor.api.Pointcut;
import ca.uhn.fhir.jpa.subscription.model.CanonicalSubscription;
import ca.uhn.fhir.jpa.subscription.model.ResourceDeliveryMessage;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

/**
 * This class is a Hook Interceptor that is invoked immediately before REST HOOK
 * deliveries. It injects a header into the subscription object at runtime, which
 * is useful in cases where an Auth header is needed in subscriptions and this header
 * is not known beforehand.
 */
@Interceptor
public class SubscriptionRestHookDynamicHeaderInterceptor {
	private static final Logger ourLog = LoggerFactory.getLogger(SubscriptionRestHookDynamicHeaderInterceptor.class);

	/**
	 * The {@link Pointcut#SUBSCRIPTION_BEFORE_REST_HOOK_DELIVERY} is invoked immediately before each
	 * REST HOOK subscription delivery.
	 *
	 * @param theDeliveryMessage This object contains details about the subscription invocation, including
	 *                           the contents of the resource that will be delivered.
	 * @param theSubscription    This object contains details about the subscription, including the delivery endpoint,
	 *                           headers to add, etc. A new copy of this object is created for every individual delivery
	 *                           so it is fine to modify it, and this will not affect other deliveries or
	 *                           subscriptions.
	 * @return Return <code>true</code> if the subscription should proceed, or <code>false</code> if it
	 * should be aborted.
	 */
	@Hook(Pointcut.SUBSCRIPTION_BEFORE_REST_HOOK_DELIVERY)
	public boolean beforeRestHookDelivery(ResourceDeliveryMessage theDeliveryMessage, CanonicalSubscription theSubscription) throws URISyntaxException, IOException, ParseException, InterruptedException {
		ourLog.info("DEMO: SUBSCRIPTION_BEFORE_REST_HOOK_DELIVERY CALLED");
		ourLog.info("DEMO: Access Token needed");
		String header = "Authorization: Bearer " + getAccessToken();
		// Add the header to the subscription, so that it will be appended during delivery
		theSubscription.addHeader(header);
		for(String str: theSubscription.getHeaders())
		{ourLog.info(str);}

		// Delivery should proceed
		return true;
	}
	private String getAccessToken() throws IOException, InterruptedException, ParseException {
		ourLog.info("DEMO: Get Access Token");
		String url = "http://localhost:8080/oauth/token";
		Map<String, String> parameters = new HashMap<>();
		parameters.put("grant_type", "client_credentials");
		String form = parameters.keySet().stream()
				.map(key -> key + "=" + URLEncoder.encode(parameters.get(key), StandardCharsets.UTF_8))
				.collect(Collectors.joining("&"));
		HttpClient client = HttpClient.newHttpClient();
		String formatted = "javainuse-client" + ":" + "javainuse-secret";
		String encoded = Base64.getEncoder().encodeToString((formatted).getBytes());
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
				.headers("Content-Type", "application/x-www-form-urlencoded", "Authorization", "Basic " + encoded)
				.POST(HttpRequest.BodyPublishers.ofString(form)).build();
		HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		ourLog.info(response.statusCode() + response.body().toString());
		new JSONParser(JSONParser.MODE_PERMISSIVE).parse(response.body().toString());
		JSONObject obj = (JSONObject)new JSONParser(JSONParser.MODE_PERMISSIVE).parse(response.body().toString());
		return obj.getAsString("access_token");
	}

}
