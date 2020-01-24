package com.anfcorp.sourcing.kafkastarter;

import com.anfcorp.sourcing.kafkastarter.config.KafkaProducerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(KafkaProducerConfig.class)
public class SpringBootHelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloWorldApplication.class, args);
    }
}
