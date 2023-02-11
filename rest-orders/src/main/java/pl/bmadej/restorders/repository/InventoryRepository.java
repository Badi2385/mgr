package pl.bmadej.restorders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bmadej.restorders.model.Inventory;

public interface InventoryRepository extends JpaRepository <Inventory, Integer> {
}
