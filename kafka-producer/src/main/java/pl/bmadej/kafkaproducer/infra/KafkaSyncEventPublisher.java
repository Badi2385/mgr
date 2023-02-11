package pl.bmadej.kafkaproducer.infra;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import pl.bmadej.kafkaproducer.domain.EventPublisher;
import pl.bmadej.kafkaproducer.domain.InternalEvent;

import java.util.concurrent.ExecutionException;

import static pl.bmadej.kafkaproducer.infra.OrderConst.Topics.ORDER_EVENTS;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaSyncEventPublisher implements EventPublisher {

    KafkaTemplate kafkaTemplate;

    @Override
    public void send(InternalEvent event) {
     final var producerRecord = new ProducerRecord<>(ORDER_EVENTS, event.getKey(), event);
     try {
         final var sendResult = kafkaTemplate.send(producerRecord);
         kafkaTemplate.flush();
         sendResult.get();
         log.info("Message sent {}", event);
     } catch (final InterruptedException e) {
         Thread.currentThread().interrupt();
         log.error("Sending interrupted", e);
     } catch (final KafkaException | ExecutionException e) {
         log.error("There was error while synchronous send event to Kafka cluster", e);
     }
    }
}
