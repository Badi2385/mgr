package pl.bmadej.restorders.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class OrderDto {

    @NonNull
    private Integer filmId;
    @NonNull
    private Integer customerId;
}
