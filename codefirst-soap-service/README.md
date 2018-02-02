Code First Web Service Development
====================================

This project exposes a backend SOAP service implementation which is called by the composite API frontend.  The flow is described in the following section.

### 1.2 SOAP Service 1

1. Accept SOAP input payload and validate it
2. Transform it to JSON and log it
3. Return a success SOAP response

## Prerequisites

The project runs as a standalone Java process using SpringBoot.

The following are required to run this project:

1. JDK 1.8 or newer
2. Maven 3.3 or newer

### Building


1. Update the `support\sample-settings.xml` file with your local maven respository path (located on line 3)

## Deployment

This project can be deployed using the followng method:

* Standalone Spring-Boot container

### Standalone Spring Boot Container

The standalone method takes advantage of the [Camel Spring Boot Plugin](http://camel.apache.org/spring-boot.html) to build and run the microservice.

Execute the following command from the root project directory:

```
mvn -s support/sample-settings.xml spring-boot:run
```