package com.mario.money.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthController {

    @GetMapping
    public String status() {
        return "UP";
    }

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String healthCheck() {
        return "UP";
    }
}
