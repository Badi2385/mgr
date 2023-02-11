package pl.bmadej.kafkaproducer.domain;

public interface EventPublisher <E extends InternalEvent> {

    void send(final E event);
}
