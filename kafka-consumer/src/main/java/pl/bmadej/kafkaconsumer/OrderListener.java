package pl.bmadej.kafkaconsumer;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pl.bmadej.kafkaconsumer.domain.OrderConsumer;
import pl.bmadej.event.OrderEvent;

import static lombok.AccessLevel.PRIVATE;
import static pl.bmadej.kafkaconsumer.infra.OrderConst.Groups.ORDER_GROUP;
import static pl.bmadej.kafkaconsumer.infra.OrderConst.Listeners.ORDER_LISTENER_CONTAINER_FACTORY;
import static pl.bmadej.kafkaconsumer.infra.OrderConst.Topics.ORDER_EVENTS;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Component
public class OrderListener {

    OrderConsumer orderConsumer;

    @KafkaListener(topics = ORDER_EVENTS, groupId = ORDER_GROUP, containerFactory = ORDER_LISTENER_CONTAINER_FACTORY)
    public void handleMessage(OrderEvent event) {
        log.info("[ORDER] content {}", event.toString());
        orderConsumer.consume(event);
    }
}
