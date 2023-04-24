package com.mario.money;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class MoneyExchange {

	public static void main(String[] args) {
		SpringApplication.run(MoneyExchange.class, args);
	}

}
