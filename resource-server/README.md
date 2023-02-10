<h1 align="center"> Resource Server -demo </h1> <br>

<p align="center">
</p>


## Table of Contents

- [Introduction](#introduction)
- [Building](#building)
- [Further Reading](#further)


## Introduction

Spring Boot Resource Server for demo purpose. Not suitable for production environment
This resource server demonstrate a boundary service for client who has rest endpoints to take updates from CDR database.

it has following endpoints:

/Patient/{id}/_history/{his}

/Patient/{id} PUT

/Patient/{id} GET

The Resource Patient is secured by OAuth client credentials. If you use Postman, you require OAuth authorization to access any of the above endpoints.

## Building
You need
* Java JDK 8 or higher
* Maven 3.1.1 or higher

To build run following

```bash
$ mvn clean install
```

### Run Local
```bash
$ mvn spring-boot:run
```

### Further Reading
https://www.oauth.com/oauth2-servers/the-resource-server/ 