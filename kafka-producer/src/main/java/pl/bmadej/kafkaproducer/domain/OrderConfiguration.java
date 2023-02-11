package pl.bmadej.kafkaproducer.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfiguration {

    @Bean
    public OrderFacade orderFacade(@Qualifier("kafkaSyncEventPublisher") final EventPublisher eventPublisher) {
        return new OrderFacade(eventPublisher);
    }
}
