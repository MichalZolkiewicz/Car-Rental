package com.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CarDto {

    private Long id;
    private String brand;
    private String model;
    private Double price;

}
