<h1 align="center"> Omara CDR interceptor </h1> <br>

<p align="center">

</p>


## Table of Contents

- [Introduction](#introduction)
- [Building](#building)
- [Installing Interceptor](#installing-interceptor)
- [Further Reading](#further-reading)



## Introduction

this is an implementation of the Subscription Hook pointcut.
This pointcut uses a simple OAuth client application that uses the OAuth2 server and Resource Server.
It calls the OAuth server to get the access token which it then adds to the Bearer token in the header.
This header is then authenticated by the resource server subsequently.
The project uses plain HTTP client to connect to OAuth Server.

The Pointcut we are using in this demo is defined by annotation Pointcut.SUBSCRIPTION_BEFORE_REST_HOOK_DELIVERY
please find it in *SubscriptionRestHookDynamicHeaderInterceptor.beforeRestHookDelivery*
Please look at this pointcut method and see how just before rest hook is called we add Authentication bearer token to the headers

You need
* Java JDK 8 or higher
* Maven 3.1.1 or higher

## Building
To build run following

```bash
$ mvn clean install
```

## Installing Interceptor

Please note you will need Admin access to you SmileCDR UI to enable the interceptor. You should already have a subscription configured and a delivery channel ready. 

1. Maven will create a JAR containing  interceptor classes in the target/ directory. 
2. Copy this JAR file to the customerlib/ directory in your Smile CDR installation 
3. Restart Smile CDR. 
4. Edit the module configuration for the relevant module in this case persistance 
5. add the fully qualified class name for your interceptor com.omara.smilecdr.demo.subscription.SubscriptionRestHookDynamicHeaderInterceptor 
6. to the Interceptor Bean Types property in your module configuration; 
7. Restart the module.

## Further Reading
In the interceptor framework, a Pointcut is a specific spot in the processing pipeline where custom logic can be added via an interceptor. The custom logic (i.e. code) itself is called a Hook. See the HAPI FHIR Interceptor Documentation (https://hapifhir.io/hapi-fhir/docs/interceptors/) for more information on the terminology used here.