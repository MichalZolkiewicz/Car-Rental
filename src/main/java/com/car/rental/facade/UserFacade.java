package com.car.rental.facade;

import com.car.rental.domain.User;
import com.car.rental.domain.UserDto;
import com.car.rental.mapper.UserMapper;
import com.car.rental.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.mapToUserDtoList(users);
    }

    public UserDto getUserDto(final long userId) {
        User user = userRepository.findById(userId);
        return userMapper.mapToUserDto(user);
    }

    public User getUser(final long userId) {
        return userRepository.findById(userId);
    }

    public void deleteUser(final long userId) {
        userRepository.deleteById(userId);
    }

    public Long saveUser(final UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userRepository.save(user);
        return user.getId();
    }

    public Long updateUserStatus(final long userId,  boolean status) {
        User user = userRepository.findById(userId);
        user.setBlocked(status);

        User newUserStatus = userRepository.save(user);
        userMapper.mapToUserDto(newUserStatus);

        return newUserStatus.getId();
    }
}
