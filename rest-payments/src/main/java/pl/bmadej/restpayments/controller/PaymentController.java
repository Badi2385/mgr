package pl.bmadej.restpayments.controller;

import jakarta.validation.Valid;
import pl.bmadej.restpayments.model.Payment;
import org.springframework.web.bind.annotation.*;
import pl.bmadej.restpayments.repository.PaymentRepository;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @PostMapping("/")
    Payment newPayment(@Valid @RequestBody Payment newPayment) {
        return paymentRepository.save(newPayment);
    }

    @GetMapping("/{id}")
    Payment getPaymentById(@PathVariable Integer id) {
        return paymentRepository.findById(id).orElseThrow(()-> new RuntimeException("No payment for id " + id));
    }
}
