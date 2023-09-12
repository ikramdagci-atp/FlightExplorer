package com.ikramdagci.domain.service;

import com.ikramdagci.domain.ex.FlightNotFoundException;
import com.ikramdagci.domain.model.dto.FlightDto;
import com.ikramdagci.domain.model.request.FlightSearchCriteria;
import com.ikramdagci.domain.model.response.FlightSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FlightSearchService {

    private final FlightService flightService;
    public FlightSearchResponse findBy(final FlightSearchCriteria sc) {
        final Collection<FlightDto> departureFlights = flightService.findFlights(sc.getDepartureAirportCode(), sc.getArrivalAirportCode(), sc.getDepartureDate());
        Collection<FlightDto> returnFlights = Collections.emptyList();
        new BeanPropertyBindingResult(sc,"SearchCriteria");
        if(Objects.nonNull(sc.getReturnDate())){
            if(sc.getReturnDate().isBefore(sc.getDepartureDate())) throw new FlightNotFoundException("Return date cannot be before the departure date."); // TODO: 3.09.2023 Create validation for this case
            returnFlights = flightService.findFlights(sc.getArrivalAirportCode(), sc.getDepartureAirportCode(), sc.getReturnDate());
        }
        return new FlightSearchResponse(departureFlights,returnFlights);
    }
}
