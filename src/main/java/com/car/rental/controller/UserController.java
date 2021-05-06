package com.car.rental.controller;

import com.car.rental.domain.UserDto;
import com.car.rental.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @GetMapping(value = "/users")
    public List<UserDto> getAllUsers() {
        return userFacade.getAllUsers();
    }

    @GetMapping(value = "/users/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return userFacade.getUserDto(userId);
    }

    @PostMapping(value = "/users")
    public Long createUser(@RequestBody UserDto userDto) {
        return userFacade.saveUser(userDto);
    }

    @PutMapping(value = "/users/{userId}")
    public Long updateUserStatus(@PathVariable Long userId, @RequestParam boolean status) {
        return userFacade.updateUserStatus(userId, status);
    }

    @DeleteMapping(value = "users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userFacade.deleteUser(userId);
    }
}
