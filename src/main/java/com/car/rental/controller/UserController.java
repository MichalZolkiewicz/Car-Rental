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

    @GetMapping(name = "/users")
    public List<UserDto> getAllUsers() {
        return userFacade.getAllUsers();
    }

    @GetMapping(name = "/users/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return userFacade.getUserDto(userId);
    }

    @PostMapping(name = "/users")
    public Long createUser(@RequestBody UserDto userDto) {
        return userFacade.saveUser(userDto);
    }

    @PutMapping(name = "/users/{userId}")
    public Long updateUserStatus(@PathVariable Long userId, @RequestParam boolean status) {
        return userFacade.updateUserStatus(userId, status);
    }

    @DeleteMapping(name = "users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userFacade.deleteUser(userId);
    }
}
