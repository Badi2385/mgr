package pl.bmadej.kafkaconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bmadej.kafkaconsumer.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
