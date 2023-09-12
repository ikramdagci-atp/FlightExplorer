package com.ikramdagci.validation;


import com.ikramdagci.domain.model.CreateFlightPayload;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

public class FlightArrivalNotBeforeDepartureValidator implements ConstraintValidator<FlightArrivalNotBeforeDeparture, CreateFlightPayload> {

    @Override
    public boolean isValid(CreateFlightPayload payload, ConstraintValidatorContext context) {
        if(Stream.of(payload,payload.getDepartureDateTime(),payload.getArrivalDateTime()).anyMatch(Objects::isNull)){
            return false;
        }
        final LocalDateTime departureDateTime = payload.getDepartureDateTime();
        final LocalDateTime arrivalDateTime = payload.getArrivalDateTime();

        return arrivalDateTime.isAfter(departureDateTime);
    }
}
