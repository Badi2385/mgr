package pl.bmadej.kafkaconsumer.infra;

public interface OrderConst {
    interface Listeners {
        String ORDER_LISTENER_CONTAINER_FACTORY = "concurrentKafkaListenerContainerFactory";
    }

    interface Groups {
        String ORDER_GROUP = "${app.kafka.group-id}";
    }

    interface Topics {
        String ORDER_EVENTS = "mgr2";
    }
}
