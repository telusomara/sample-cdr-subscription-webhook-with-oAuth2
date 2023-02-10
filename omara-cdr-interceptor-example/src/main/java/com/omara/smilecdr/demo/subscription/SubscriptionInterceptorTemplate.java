package com.omara.smilecdr.demo.subscription;

import ca.uhn.fhir.interceptor.api.Hook;
import ca.uhn.fhir.interceptor.api.Interceptor;
import ca.uhn.fhir.interceptor.api.Pointcut;
import ca.uhn.fhir.jpa.searchparam.matcher.InMemoryMatchResult;
import ca.uhn.fhir.jpa.subscription.model.CanonicalSubscription;
import ca.uhn.fhir.jpa.subscription.model.ResourceDeliveryMessage;
import ca.uhn.fhir.jpa.subscription.model.ResourceModifiedJsonMessage;
import ca.uhn.fhir.jpa.subscription.model.ResourceModifiedMessage;
import ca.uhn.fhir.util.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sample Subscription Interceptor implementing all SUBSCRIPTION_XXX pointcuts.
 * It is intended to be used in Subscription module 'Interceptor Bean Types'.
 * Can be used as a starting point for your subscription interceptor.
 */
@SuppressWarnings({"unused", "EmptyTryBlock"})
@Interceptor
public class SubscriptionInterceptorTemplate {

	private static final Logger ourLog = LoggerFactory.getLogger(SubscriptionInterceptorTemplate.class);

	@Hook(Pointcut.SUBSCRIPTION_AFTER_ACTIVE_SUBSCRIPTION_REGISTERED)
	public void subscriptionAfterActiveSubscriptionRegistered(
		CanonicalSubscription theCanonicalSubscription) {

		ourLog.info("Interceptor SUBSCRIPTION_AFTER_ACTIVE_SUBSCRIPTION_REGISTERED - started");
		StopWatch stopWatch = new StopWatch();
		try {
			// your implementation goes here
		} finally {
			ourLog.info("Interceptor SUBSCRIPTION_AFTER_ACTIVE_SUBSCRIPTION_REGISTERED - ended, execution took {}", stopWatch);
		}
	}

	@Hook(Pointcut.SUBSCRIPTION_AFTER_ACTIVE_SUBSCRIPTION_UNREGISTERED)
	public void subscriptionAfterActiveSubscriptionUnregistered() {

		ourLog.info("Interceptor SUBSCRIPTION_AFTER_ACTIVE_SUBSCRIPTION_UNREGISTERED - started");
		StopWatch stopWatch = new StopWatch();
		try {
			// your implementation goes here
		} finally {
			ourLog.info("Interceptor SUBSCRIPTION_AFTER_ACTIVE_SUBSCRIPTION_UNREGISTERED - ended, execution took {}", stopWatch);
		}
	}

	@Hook(Pointcut.SUBSCRIPTION_RESOURCE_MODIFIED)
	public boolean subscriptionResourceModified(
		ResourceModifiedMessage theResourceModifiedMessage) {

		ourLog.info("Interceptor SUBSCRIPTION_RESOURCE_MODIFIED - started");
		StopWatch stopWatch = new StopWatch();
		try {
			// your implementation goes here
		} finally {
			ourLog.info("Interceptor SUBSCRIPTION_RESOURCE_MODIFIED - ended, execution took {}", stopWatch);
		}
		return true;
	}

	@Hook(Pointcut.SUBSCRIPTION_RESOURCE_DID_NOT_MATCH_ANY_SUBSCRIPTIONS)
	public void subscriptionResourceDidNotMatchAnySubscriptions(
		ResourceModifiedMessage theResourceModifiedMessage) {

		ourLog.info("Interceptor SUBSCRIPTION_RESOURCE_DID_NOT_MATCH_ANY_SUBSCRIPTIONS - started");
		StopWatch stopWatch = new StopWatch();
		try {
			// your implementation goes here
		} finally {
			ourLog.info("Interceptor SUBSCRIPTION_RESOURCE_DID_NOT_MATCH_ANY_SUBSCRIPTIONS - ended, execution took {}", stopWatch);
		}
	}

	@Hook(Pointcut.SUBSCRIPTION_RESOURCE_MATCHED)
	public boolean subscriptionResourceMatched(
		CanonicalSubscription theCanonicalSubscription,
		ResourceDeliveryMessage theResourceDeliveryMessage,
		InMemoryMatchResult theInMemoryMatchResult) {

		ourLog.info("Interceptor SUBSCRIPTION_RESOURCE_MATCHED - started");
		StopWatch stopWatch = new StopWatch();
		try {
			// your implementation goes here
		} finally {
			ourLog.info("Interceptor SUBSCRIPTION_RESOURCE_MATCHED - ended, execution took {}", stopWatch);
		}
		return true;
	}

	@Hook(Pointcut.SUBSCRIPTION_BEFORE_PERSISTED_RESOURCE_CHECKED)
	public boolean subscriptionBeforePersistedResourceChecked(
		ResourceModifiedMessage theResourceModifiedMessage) {

		ourLog.info("Interceptor SUBSCRIPTION_BEFORE_PERSISTED_RESOURCE_CHECKED - started");
		StopWatch stopWatch = new StopWatch();
		try {
			// your implementation goes here
		} finally {
			ourLog.info("Interceptor SUBSCRIPTION_BEFORE_PERSISTED_RESOURCE_CHECKED - ended, execution took {}", stopWatch);
		}
		return true;
	}

	@Hook(Pointcut.SUBSCRIPTION_AFTER_PERSISTED_RESOURCE_CHECKED)
	public void subscriptionAfterPersistedResourceChecked(
		ResourceModifiedMessage theResourceModifiedMessage) {

		ourLog.info("Interceptor SUBSCRIPTION_AFTER_PERSISTED_RESOURCE_CHECKED - started");
		StopWatch stopWatch = new StopWatch();
		try {
			// your implementation goes here
		} finally {
			ourLog.info("Interceptor SUBSCRIPTION_AFTER_PERSISTED_RESOURCE_CHECKED - ended, execution took {}", stopWatch);
		}
	}

	@Hook(Pointcut.SUBSCRIPTION_BEFORE_DELIVERY)
	public boolean subscriptionBeforeDelivery(
		CanonicalSubscription theCanonicalSubscription,
		ResourceDeliveryMessage theResourceDeliveryMessage) {

		ourLog.info("Interceptor SUBSCRIPTION_BEFORE_DELIVERY - started");
		StopWatch stopWatch = new StopWatch();
		try {
			// your implementation goes here
		} finally {
			ourLog.info("Interceptor SUBSCRIPTION_BEFORE_DELIVERY - ended, execution took {}", stopWatch);
		}
		return true;
	}

	@Hook(Pointcut.SUBSCRIPTION_AFTER_DELIVERY)
	public void subscriptionAfterDelivery(
		CanonicalSubscription theCanonicalSubscription,
		ResourceDeliveryMessage theResourceDeliveryMessage) {

		ourLog.info("Interceptor SUBSCRIPTION_AFTER_DELIVERY - started");
		StopWatch stopWatch = new StopWatch();
		try {
			// your implementation goes here
		} finally {
			ourLog.info("Interceptor SUBSCRIPTION_AFTER_DELIVERY - ended, execution took {}", stopWatch);
		}
	}

	@Hook(Pointcut.SUBSCRIPTION_AFTER_DELIVERY_FAILED)
	public boolean subscriptionAfterDeliveryFailed(
		ResourceDeliveryMessage theResourceDeliveryMessage,
		Exception theException) {

		ourLog.info("Interceptor SUBSCRIPTION_AFTER_DELIVERY_FAILED - started");
		StopWatch stopWatch = new StopWatch();
		try {
			// your implementation goes here
		} finally {
			ourLog.info("Interceptor SUBSCRIPTION_AFTER_DELIVERY_FAILED - ended, execution took {}", stopWatch);
		}
		return true;
	}

	@Hook(Pointcut.SUBSCRIPTION_BEFORE_REST_HOOK_DELIVERY)
	public boolean subscriptionBeforeRestHookDelivery(
		CanonicalSubscription theCanonicalSubscription,
		ResourceDeliveryMessage theResourceDeliveryMessage) {

		ourLog.info("Interceptor SUBSCRIPTION_BEFORE_REST_HOOK_DELIVERY - started");
		StopWatch stopWatch = new StopWatch();
		try {
			// your implementation goes here
		} finally {
			ourLog.info("Interceptor SUBSCRIPTION_BEFORE_REST_HOOK_DELIVERY - ended, execution took {}", stopWatch);
		}
		return true;
	}

	@Hook(Pointcut.SUBSCRIPTION_AFTER_REST_HOOK_DELIVERY)
	public void subscriptionAfterRestHookDelivery(
		CanonicalSubscription theCanonicalSubscription,
		ResourceDeliveryMessage theResourceDeliveryMessage) {

		ourLog.info("Interceptor SUBSCRIPTION_AFTER_REST_HOOK_DELIVERY - started");
		StopWatch stopWatch = new StopWatch();
		try {
			// your implementation goes here
		} finally {
			ourLog.info("Interceptor SUBSCRIPTION_AFTER_REST_HOOK_DELIVERY - ended, execution took {}", stopWatch);
		}
	}

	@Hook(Pointcut.SUBSCRIPTION_BEFORE_MESSAGE_DELIVERY)
	public boolean subscriptionBeforeMessageDelivery(
		CanonicalSubscription theCanonicalSubscription,
		ResourceDeliveryMessage theResourceDeliveryMessage,
		ResourceModifiedJsonMessage theResourceModifiedJsonMessage) {

		ourLog.info("Interceptor SUBSCRIPTION_BEFORE_MESSAGE_DELIVERY - started");
		StopWatch stopWatch = new StopWatch();
		try {
			// your implementation goes here
		} finally {
			ourLog.info("Interceptor SUBSCRIPTION_BEFORE_MESSAGE_DELIVERY - ended, execution took {}", stopWatch);
		}
		return true;
	}

	@Hook(Pointcut.SUBSCRIPTION_AFTER_MESSAGE_DELIVERY)
	public void subscriptionAfterMessageDelivery(
		CanonicalSubscription theCanonicalSubscription,
		ResourceDeliveryMessage theResourceDeliveryMessage) {

		ourLog.info("Interceptor SUBSCRIPTION_AFTER_MESSAGE_DELIVERY - started");
		StopWatch stopWatch = new StopWatch();
		try {
			// your implementation goes here
		} finally {
			ourLog.info("Interceptor SUBSCRIPTION_AFTER_MESSAGE_DELIVERY - ended, execution took {}", stopWatch);
		}
	}
}
