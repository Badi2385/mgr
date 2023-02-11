package pl.bmadej.kafkaconsumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {

    @Value("${payments.url}")
    private String paymentsUrl;

    @Bean
    public WebClient paymentsClient() {
        return WebClient.create(paymentsUrl);
    }
}
