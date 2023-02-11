package pl.bmadej.kafkaconsumer.domain;

import pl.bmadej.kafkaconsumer.model.RentalWithPaymentDto;

public interface OrderRepository {
    RentalWithPaymentDto save (final Order order);
}
