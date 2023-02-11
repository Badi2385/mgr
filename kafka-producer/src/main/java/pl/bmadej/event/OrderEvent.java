package pl.bmadej.event;

import lombok.Value;
import pl.bmadej.kafkaproducer.domain.InternalEvent;
import pl.bmadej.kafkaproducer.web.OrderDto;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Value
public class OrderEvent implements InternalEvent {
    UUID eventId;
    Integer filmId;
    Integer customerId;

    public static OrderEvent fromOrderDto(final OrderDto orderDto) {
        requireNonNull(orderDto.getCustomerId());

        return new OrderEvent(UUID.randomUUID(),
                orderDto.getFilmId(),
                orderDto.getCustomerId());
    }

    @Override
    public String getKey() {
        return customerId.toString();
    }
}
