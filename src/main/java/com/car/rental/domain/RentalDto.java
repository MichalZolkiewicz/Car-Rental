package com.car.rental.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class RentalDto {

    private final Long id;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Double price;

}
