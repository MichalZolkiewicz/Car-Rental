package com.car.rental.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class RaceTrackDto {

    private final Long id;
    private final String trackName;
    private final boolean isClosed;
}
