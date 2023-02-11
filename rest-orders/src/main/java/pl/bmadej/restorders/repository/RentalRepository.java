package pl.bmadej.restorders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bmadej.restorders.model.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
