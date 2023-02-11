package pl.bmadej.kafkaproducer.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import pl.bmadej.kafkaproducer.domain.EventPublisher;
import pl.bmadej.kafkaproducer.domain.InternalEvent;

@Configuration
public class KafkaEventPublisherConfiguration {

    @Bean
    EventPublisher kafkaSyncEventPublisher(final KafkaTemplate<String, InternalEvent> kafkaTemplate) {
        return new KafkaSyncEventPublisher(kafkaTemplate);
    }
}
