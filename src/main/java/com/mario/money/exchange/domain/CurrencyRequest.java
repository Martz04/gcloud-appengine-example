package com.mario.money.exchange.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyRequest {

    private double value;
    private CurrencyCodes fromCurrency;
    private CurrencyCodes toCurrency;
}
