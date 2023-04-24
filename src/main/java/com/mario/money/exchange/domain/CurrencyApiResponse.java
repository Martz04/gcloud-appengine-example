package com.mario.money.exchange.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class CurrencyApiResponse {
    @JsonProperty("data")
    Map<String, Double> currencies;
}
