# Question
Write a RESTful service which calculates and returns all the prime numbers up to and including a number provided.

**Example**

The REST call would look something like http://your.host.com/primes/10 and should return JSON content:

    {
        "Initial":  10,
        "Primes": [2,3,5,7]
    }


## Requirements
* The project must be written in Java 8 or above.
* The project must use Maven OR Gradle to build, test and run.
* The project must have unit and integration tests.
* The project must be runnable in that the service should be hosted in a container e.g. Tomcat, Jetty, Spring Boot etc.
* You may use any frameworks or libraries for support e.g. Spring MVC, Apache CXF etc.
* The project must be accessible from Github.

## Optional Extensions
* Deploy the solution to a chosen platform that we can access.
* Consider supporting varying return content types such as XML based, that should be configurable using the requested media type.
* Consider ways to improve overall performance e.g. caching results, concurrent algorithm
* Consider supporting multiple algorithms that can be switched based on optional parameters
* Please respond with the coding assignment link to github.

# Build and Run

1. Build the code base `.\mvnw clean install`
2. Run via Maven using Boot: `.\mvnw spring-boot:run`

Once the API is running, it can be consumed:

`GET localhost:8080/primes/10` - to get the list of prime number till the given number

`POST localhost:8080/primes/10?algorithmType=BRUTE_FORCE` - to get the list of prime number till the given number along with given algorithm.

Currently, SieveOfEratosthenes Algorithm and BruteForceAlgorithm are supported

All tests will be executed as part of build but can also be run independently if need be.