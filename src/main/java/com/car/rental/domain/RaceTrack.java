package com.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "race_track")
public class RaceTrack {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "track_name")
    private String trackName;

    @Column(name = "track_closed")
    private boolean isClosed;

}
