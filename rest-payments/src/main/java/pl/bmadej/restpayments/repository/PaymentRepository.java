package pl.bmadej.restpayments.repository;

import pl.bmadej.restpayments.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository <Payment, Integer> {
}
