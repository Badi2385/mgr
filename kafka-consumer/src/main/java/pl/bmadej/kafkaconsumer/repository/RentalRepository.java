package pl.bmadej.kafkaconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bmadej.kafkaconsumer.model.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
