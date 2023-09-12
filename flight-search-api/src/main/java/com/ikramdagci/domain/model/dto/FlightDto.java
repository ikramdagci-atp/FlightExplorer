package com.ikramdagci.domain.model.dto;

import com.ikramdagci.domain.model.MonetaryAmountWrapper;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
public record FlightDto(
        Long id,
        AirportDto departureAirport,
        AirportDto arrivalAirport,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime departureDateTime,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime arrivalDateTime,
        MonetaryAmountWrapper price
) implements Serializable {}
