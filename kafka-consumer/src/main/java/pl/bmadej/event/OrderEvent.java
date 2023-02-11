package pl.bmadej.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Value
public class OrderEvent {

    @JsonCreator
    public  OrderEvent(
            @JsonProperty("eventId") UUID eventId,
            @JsonProperty("filmId") Integer filmId,
            @JsonProperty("customerId") Integer customerId) {

        requireNonNull(eventId);
        requireNonNull(filmId);
        requireNonNull(customerId);

        this.eventId = eventId;
        this.filmId = filmId;
        this.customerId = customerId;
    }

    UUID eventId;
    Integer filmId;
    Integer customerId;

}
