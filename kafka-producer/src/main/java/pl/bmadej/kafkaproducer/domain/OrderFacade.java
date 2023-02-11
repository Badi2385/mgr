package pl.bmadej.kafkaproducer.domain;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import pl.bmadej.event.OrderEvent;
import pl.bmadej.kafkaproducer.web.OrderDto;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OrderFacade {

    EventPublisher eventPublisher;

    public void sendEvent(final OrderDto orderDto) {
        final var eventValue = OrderEvent.fromOrderDto(orderDto);
        eventPublisher.send(eventValue);
    }
}
