package com.car.rental.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CarDto {

    private final Long id;
    private final String brand;
    private final String model;
    private final Double price;
    private final String status;

}
