package pl.bmadej.restorders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bmadej.restorders.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
