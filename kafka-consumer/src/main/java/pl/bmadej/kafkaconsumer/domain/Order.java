package pl.bmadej.kafkaconsumer.domain;

import lombok.Value;
import pl.bmadej.event.OrderEvent;

import java.io.Serializable;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Value
public class Order implements Serializable {
    UUID eventId;
    Integer filmId;
    Integer customerId;

    public static Order fromOrderEvent(final OrderEvent orderEvent) {
        requireNonNull(orderEvent.getEventId());
        requireNonNull(orderEvent.getFilmId());
        requireNonNull(orderEvent.getCustomerId());

        return new Order(orderEvent.getEventId(),
                orderEvent.getFilmId(),
                orderEvent.getCustomerId());
    }

}
