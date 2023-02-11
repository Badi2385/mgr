package pl.bmadej.kafkaconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class RentalWithPaymentDto {

    @NonNull
    private Integer rentalId;

    @NonNull
    private Integer paymentId;
}
