package com.car.rental.controller;

import com.car.rental.domain.CarDto;
import com.car.rental.facade.CarFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CarController {

    private final CarFacade carFacade;

    @GetMapping(value = "/cars")
    public List<CarDto> getCars() {
        return carFacade.getAllCars();
    }

    @GetMapping(value = "/cars/{carId}")
    public CarDto getCar(@PathVariable Long carId) {
        return carFacade.getCarDto(carId);
    }

    @PostMapping(value = "/cars", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long addCar(@RequestBody CarDto carDto) {
        return carFacade.saveCar(carDto);
    }

    @PutMapping(value = "/cars/{carId}")
    public Long updateCarStatus(@PathVariable Long carId, @RequestParam String status) {
        return carFacade.updateCarStatus(carId, status);
    }

    @DeleteMapping(value = "/cars/{carId}")
    public void deleteCar(@PathVariable Long carId) {
        carFacade.deleteCar(carId);
    }
}
