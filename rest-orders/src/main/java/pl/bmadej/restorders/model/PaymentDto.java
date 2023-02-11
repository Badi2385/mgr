package pl.bmadej.restorders.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PaymentDto {

    private Integer id;
    @NonNull
    private Integer customerId;
    @NonNull
    private Integer rentalId;
    @NonNull
    private BigDecimal amount;

}