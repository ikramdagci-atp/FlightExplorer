package com.ikramdagci.domain.model.response;

import com.ikramdagci.domain.model.dto.FlightDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FlightSearchResponse {

    private Collection<FlightDto> departureFlights;
    private Collection<FlightDto> returnFlights;


}
