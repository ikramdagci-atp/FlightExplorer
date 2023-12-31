package com.ikramdagci.domain.entity;

import com.ikramdagci.converter.MonetaryAmountConverter;
import jakarta.persistence.*;
import lombok.*;

import javax.money.MonetaryAmount;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_flight")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight extends BaseEntity{

    @ManyToOne
    private Airport departureAirport;
    @ManyToOne
    private Airport arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount price;


}
