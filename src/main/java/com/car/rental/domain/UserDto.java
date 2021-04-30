package com.car.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private boolean isBlocked;
}
