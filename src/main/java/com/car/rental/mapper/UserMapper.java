package com.car.rental.mapper;

import com.car.rental.domain.User;
import com.car.rental.domain.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    public User mapToUser(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getLastname(), userDto.getEmail(), userDto.isBlocked());
    }

    public UserDto mapToUserDto(final User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .isBlocked(user.isBlocked())
                .build();
    }

    public List<UserDto> mapToUserDtoList(List<User> usersList) {
        return usersList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
