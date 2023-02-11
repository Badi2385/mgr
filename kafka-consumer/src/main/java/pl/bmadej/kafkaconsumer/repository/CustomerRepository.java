package pl.bmadej.kafkaconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bmadej.kafkaconsumer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
