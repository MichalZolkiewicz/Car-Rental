package com.car.rental.controller;

import com.car.rental.domain.CarDto;
import com.car.rental.facade.CarFacade;
import lombok.RequiredArgsConstructor;
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

    @PostMapping(value = "/cars")
    public Long addCar(@RequestBody CarDto carDto) {
        return carFacade.saveCar(carDto);
    }

    @PutMapping(value = "/cars")
    public Long updateCarStatus(@RequestParam Long copyId, @RequestParam String status) {
        return carFacade.updateCarStatus(copyId, status);
    }

    @DeleteMapping(value = "/cars/{carId}")
    public void deleteCar(@PathVariable Long carId) {
        carFacade.deleteCar(carId);
    }
}
