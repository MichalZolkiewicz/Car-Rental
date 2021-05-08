package com.car.rental.mapper;

import com.car.rental.domain.Car;
import com.car.rental.domain.CarDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarMapper {

    public Car mapToCar(CarDto carDto) {
        return new Car(carDto.getBrand(), carDto.getModel(), carDto.getPrice());
    }

    public CarDto mapToCarDto(Car car) {

        return CarDto.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .price(car.getPrice())
                .consumption(car.getConsumption())
                .status(car.getStatus())
                .build();
    }

    public List<CarDto> mapToCarDtoList(List<Car> carList) {
        return carList.stream()
                .map(this::mapToCarDto)
                .collect(Collectors.toList());
    }
}
