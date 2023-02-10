<h1 align="center"> Omara Interceptor Demo </h1> <br>

<p align="center"></p>


## Table of Contents

- [Introduction](#introduction)
- [Process Flow](#process-flow)

- [Further Reading](#further-reading)

## Introduction

This is demonstration of Setting up a secure delivery channel with Omara CDR. Omara CDR is based on Smile CDR. https://smilecdr.com/  

There are three Spring boot projects in this demo. more information is in readme of the projects. 

* omara-cdr-interceptor-example
* omara-oauth-server
* resource-server


## Process Flow

* The interceptor application (omara-cdr-interceptor-example) requests access to the /patient/ endpoint on the resource server 
by sending a request to the OAuth server. The request includes its own credentials (client ID and secret) 
and the client_credentials grant type .

* The OAuth server (omara-oauth-server) authenticates the client by validating the client ID and secret and granting access to the client.

* The omara-oauth-server issues an access token to the client application. The token represents the client's permission to access its own resources.

* The omara-oauth-server sends a request to the resource server(resource-server), including the access token obtained from the OAuth server.

* The interceptor application can now use the access token to access its own resources on the resource server until the token expires.

## Pre Requisite 

* You have Omara exchange up and running 
* You have access to SmileCDR admin UI 
* Java 8 or above to compile and run Oauth and Resource Server 
* Mechanism in place to upload a interceptor Jar to Omara CDR 
* PostMan or a tool to send rest apit request to a FHIR Endpoint of Omara CDR. 



### Further Reading
* smileCDR https://smilecdr.com/
* Omara Documentation https://omara.atlassian.net/wiki/spaces/OCS/pages/886341633/Setting+up+a+secure+delivery+channel+with+Omara+CDR

