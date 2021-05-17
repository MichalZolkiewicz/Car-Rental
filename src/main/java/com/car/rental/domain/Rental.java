package com.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "track_id")
    private RaceTrack raceTrack;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "kilometers_done")
    private Long kilometersDone;

    public Rental(Long id, LocalDate startDate, LocalDate returnDate, Double price) {
        this.id = id;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.price = price;
    }
}
