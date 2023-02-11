package pl.bmadej.kafkaconsumer.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    public OrderConsumer orderFacade(final OrderRepository orderRepository) {
        return new OrderFacade(orderRepository);
    }
}
