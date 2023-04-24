package com.mario.money;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExchangeControllerTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private WebTestClient testClient;

    @Test
    public void testHealthCheck() throws InterruptedException {
        testClient.post()
                .uri("/exchange")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(" { \"value\": 100," +
                        "\"fromCurrency\": \"USD\"," +
                        "\"toCurrency\": \"MXN\"}"
                )
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(String.class);
    }

}
