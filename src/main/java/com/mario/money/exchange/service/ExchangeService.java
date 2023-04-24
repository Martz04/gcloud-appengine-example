package com.mario.money.exchange.service;

import com.mario.money.exchange.configuration.ExchangeServiceConfiguration;
import com.mario.money.exchange.domain.CurrencyApiResponse;
import com.mario.money.exchange.domain.CurrencyRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Service
public class ExchangeService {

    private final ExchangeServiceConfiguration configuration;
    private final RestTemplate restTemplate;

    public ExchangeService(ExchangeServiceConfiguration configuration) {
        this.configuration = configuration;
        this.restTemplate = new RestTemplate();
    }

    public String tranformCurrency(CurrencyRequest request) {

        // https://api.freecurrencyapi.com/v1/latest?apikey=KEY&currencies=MXN
        URI uri = UriComponentsBuilder
                .fromHttpUrl(configuration.getUrl())
                .queryParam("apikey", configuration.getKey())
                .queryParam("base_currency", request.getFromCurrency().toString())
                .queryParam("currencies", request.getToCurrency().toString())
                .build()
                .toUri();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        if(response.getStatusCode() == HttpStatus.OK) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                CurrencyApiResponse currencyMap = mapper.readValue(response.getBody(), CurrencyApiResponse.class);

                double toValue = currencyMap.getCurrencies().entrySet().stream()
                        .filter(entry -> entry.getKey().equals(request.getToCurrency().toString()))
                        .map(Map.Entry::getValue)
                        .mapToDouble(optValue -> optValue)
                        .findFirst().orElse(0.0);

                return String.valueOf(request.getValue() * toValue);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return "";
    }
}
