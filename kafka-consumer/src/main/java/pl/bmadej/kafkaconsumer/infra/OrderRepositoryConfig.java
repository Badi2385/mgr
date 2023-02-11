package pl.bmadej.kafkaconsumer.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bmadej.kafkaconsumer.domain.Order;
import pl.bmadej.kafkaconsumer.domain.OrderRepository;
import pl.bmadej.kafkaconsumer.model.RentalWithPaymentDto;
import pl.bmadej.kafkaconsumer.service.OrderService;

@Configuration
public class OrderRepositoryConfig {

    @Bean
    public OrderRepository orderRepository(OrderService orderService) {
        return new OrderRepositoryImpl(orderService);
    }

}
