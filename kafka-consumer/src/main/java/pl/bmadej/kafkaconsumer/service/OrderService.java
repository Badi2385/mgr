package pl.bmadej.kafkaconsumer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import pl.bmadej.kafkaconsumer.domain.Order;
import pl.bmadej.kafkaconsumer.model.*;
import pl.bmadej.kafkaconsumer.repository.CustomerRepository;
import pl.bmadej.kafkaconsumer.repository.FilmRepository;
import pl.bmadej.kafkaconsumer.repository.InventoryRepository;
import pl.bmadej.kafkaconsumer.repository.RentalRepository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class OrderService {

    private final FilmRepository filmRepository;
    private final InventoryRepository inventoryRepository;
    private final CustomerRepository customerRepository;
    private final RentalRepository rentalRepository;

    private final WebClient paymentsClient;

    public OrderService(FilmRepository filmRepository,
                        InventoryRepository inventoryRepository,
                        CustomerRepository customerRepository,
                        RentalRepository rentalRepository, WebClient paymentsClient) {
        this.filmRepository = filmRepository;
        this.inventoryRepository = inventoryRepository;
        this.customerRepository = customerRepository;
        this.rentalRepository = rentalRepository;
        this.paymentsClient = paymentsClient;
    }

    @Transactional
    public RentalWithPaymentDto createOrder(Order order) {
        Integer filmId = order.getFilmId();
        Film film = filmRepository.findById(filmId).
                orElseThrow(()-> new RuntimeException("No film for id " + filmId));

        Inventory inventory = new Inventory();
        inventory.setFilm(film);
        inventory = inventoryRepository.save(inventory);

        Integer customerId = order.getCustomerId();
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new RuntimeException("No customer for id " + customerId));

        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        Rental rental = new Rental();
        rental.setInventory(inventory);
        rental.setCustomer(customer);
        rental.setRentalDate(offsetDateTime);
        rental.setReturnDate(offsetDateTime.plusDays(film.getRentalDuration()));
        rental = rentalRepository.save(rental);

        Integer rentalId = rental.getId();
        BigDecimal amount = film.getRentalRate();

        PaymentDto paymentDto = PaymentDto.builder()
                .customerId(customerId)
                .rentalId(rentalId)
                .amount(amount)
                .build();

        ResponseEntity<PaymentDto> response = paymentsClient.post()
                .body(Mono.just(paymentDto), PaymentDto.class)
                .retrieve()
                .toEntity(PaymentDto.class)
                .block();

        paymentDto = response.getBody();
        Integer paymentId = paymentDto.getId();

        return new RentalWithPaymentDto(rentalId, paymentId);
    }
}
