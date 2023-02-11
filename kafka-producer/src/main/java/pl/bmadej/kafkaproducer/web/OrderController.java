package pl.bmadej.kafkaproducer.web;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bmadej.kafkaproducer.domain.OrderFacade;

@RestController
@RequestMapping(path = "/orders")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrderController {

    OrderFacade orderFacade;

    @PostMapping("/")
    public ResponseEntity<?> newOrder(@Valid @RequestBody OrderDto orderDto) {
        orderFacade.sendEvent(orderDto);
        return ResponseEntity.ok().build();
    }

}
