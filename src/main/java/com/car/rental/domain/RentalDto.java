package com.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class RentalDto {

    private Long id;
    private String model;
    private String username;
    private LocalDate startDate;
    private LocalDate endDate;

}
