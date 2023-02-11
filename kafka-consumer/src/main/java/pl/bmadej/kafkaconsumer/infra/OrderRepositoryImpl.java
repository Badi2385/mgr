package pl.bmadej.kafkaconsumer.infra;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import pl.bmadej.kafkaconsumer.domain.Order;
import pl.bmadej.kafkaconsumer.domain.OrderRepository;
import pl.bmadej.kafkaconsumer.model.RentalWithPaymentDto;
import pl.bmadej.kafkaconsumer.service.OrderService;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OrderRepositoryImpl implements OrderRepository {

    OrderService orderService;

    @Override
    public RentalWithPaymentDto save(Order order) {
        return orderService.createOrder(order);
    }
}
