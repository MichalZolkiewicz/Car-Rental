package com.car.rental.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "cars")
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private Double price;

    @Column(name = "consumption")
    private Double consumption;

    @Column(name = "status")
    private String status;

    public Car(String brand, String model, Double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
}
