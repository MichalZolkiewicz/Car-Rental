package com.car.rental.mapper;

import com.car.rental.domain.Rental;
import com.car.rental.domain.RentalDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalMapper {

    public Rental mapToRental(RentalDto rentalDto) {
        return new Rental(rentalDto.getId(), rentalDto.getStartDate(), rentalDto.getEndDate(), rentalDto.getPrice());
    }

    public RentalDto mapToRentalDto(Rental rental) {
        return RentalDto.builder()
                .id(rental.getId())
                .startDate(rental.getStartDate())
                .endDate(rental.getReturnDate())
                .price(rental.getPrice())
                .build();
    }

    public List<RentalDto> mapToRentalDtoList(List<Rental> rentalList) {
        return rentalList.stream()
                .map(this::mapToRentalDto)
                .collect(Collectors.toList());
    }
}
