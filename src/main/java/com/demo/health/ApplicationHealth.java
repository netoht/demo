package com.demo.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ApplicationHealth implements HealthIndicator {

    @Override
    public Health health() {
        boolean error = check(); // perform some specific health check
        if (error) {
            return Health
                    .down()
                    .withDetail("Message Error", "Exemplo, algo deu errado ao validar a aplicacao!")
                    .build();
        }
        return Health.up().build();
    }

    private boolean check() {
        return true;
    }
}
