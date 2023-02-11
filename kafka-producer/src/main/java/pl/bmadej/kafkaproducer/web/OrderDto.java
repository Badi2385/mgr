package pl.bmadej.kafkaproducer.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OrderDto {

    @NonNull
    Integer filmId;
    @NonNull
    Integer customerId;
}
