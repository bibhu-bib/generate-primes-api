package com.west.prime.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.net.URI;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PrimeControllerTest {

    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void findPrime_shouldReturnWith200() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<?> response = restTemplate.exchange(createURLWithPort("/primes/10"), HttpMethod.GET, entity, String.class);

        String expected = "{\"initial\":10,\"primes\":[2,3,5,7]}";

        assertEquals(expected, response.getBody());
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void findPrime_shouldReturnXMLWith200() {
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<?> response = restTemplate.exchange(createURLWithPort("/primes/10"), HttpMethod.GET, entity, String.class);

        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><prime><initial>10</initial><primes>2</primes><primes>3</primes><primes>5</primes><primes>7</primes></prime>";

        assertEquals(expected, response.getBody());
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void findPrimeWithDefaultAlgorithm() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<?> response = restTemplate.exchange(createURLWithPort("/primes/12?algorithmType=BRUTE_FORCE"), HttpMethod.GET, entity, String.class);

        String expected = "{\"initial\":12,\"primes\":[2,3,5,7,11]}";

        assertEquals(expected, response.getBody());
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void findPrimeWithSieveAlgorithm() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<?> response = restTemplate.exchange(createURLWithPort("/primes/13?algorithmType=SIEVE"), HttpMethod.GET, entity, String.class);

        String expected = "{\"initial\":13,\"primes\":[2,3,5,7,11,13]}";

        assertEquals(expected, response.getBody());
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void findPrime_whenNumberLessThan2() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<?> response = restTemplate.exchange(createURLWithPort("/primes/1"), HttpMethod.GET, entity, String.class);

        assertEquals(400, response.getStatusCode().value());
    }

    @Test
    public void findPrime_whenNumberIsNegative() {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<?> response = restTemplate.exchange(createURLWithPort("/primes/-1"), HttpMethod.GET, entity, String.class);

        assertEquals(400, response.getStatusCode().value());
    }

    private URI createURLWithPort(String uri) {
        return URI.create("http://localhost:" + port + uri);
    }

}