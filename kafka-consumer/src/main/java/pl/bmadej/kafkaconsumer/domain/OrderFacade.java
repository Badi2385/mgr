package pl.bmadej.kafkaconsumer.domain;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import pl.bmadej.event.OrderEvent;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class OrderFacade implements OrderConsumer {

    OrderRepository orderRepository;

    @Override
    public void consume(OrderEvent event) {
        final var order = Order.fromOrderEvent(event);
        processMessage(order);
    }

    private void processMessage(final Order order) {
        orderRepository.save(order);
    }
}
