package com.car.rental.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDto {

    private final Long id;
    private final String name;
    private final String lastname;
    private final String email;
    private final boolean isBlocked;
}
