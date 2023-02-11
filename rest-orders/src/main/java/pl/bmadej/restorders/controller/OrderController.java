package pl.bmadej.restorders.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bmadej.restorders.model.*;
import pl.bmadej.restorders.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    ResponseEntity newOrder(@Valid @RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);
        return ResponseEntity.ok().build();
    }
}
