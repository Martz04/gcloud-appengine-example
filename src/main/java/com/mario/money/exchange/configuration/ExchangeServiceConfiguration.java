package com.mario.money.exchange.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;;

@Data
@Configuration
@PropertySource("classpath:external.properties")
@ConfigurationProperties(prefix = "exchange.service")
public class ExchangeServiceConfiguration {

    private String url;
    private boolean flag;
    private String key;

}
