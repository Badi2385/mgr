package pl.bmadej.kafkaconsumer.domain;

import pl.bmadej.event.OrderEvent;

public interface OrderConsumer {

    void consume(final OrderEvent event);
}
