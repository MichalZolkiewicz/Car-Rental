package com.car.rental.facade;

import com.car.rental.domain.Car;
import com.car.rental.domain.Rental;
import com.car.rental.domain.RentalDto;
import com.car.rental.mapper.RentalMapper;
import com.car.rental.repositories.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalFacade {

    private final PetrolFacade petrolFacade;
    private final CarFacade carFacade;
    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;

    public List<RentalDto> getAllRental() {
        List<Rental> rentalList = rentalRepository.findAll();
        return rentalMapper.mapToRentalDtoList(rentalList);
    }

    public RentalDto getRentalDto(final long id) {
        Rental rental = rentalRepository.findById(id);
        return rentalMapper.mapToRentalDto(rental);
    }

    public Long saveRental(final RentalDto rentalDto) {
        Rental rental = rentalMapper.mapToRental(rentalDto);
        rentalRepository.save(rental);
        return rental.getId();
    }

    public Rental getRental(final long rentalId) {
        return rentalRepository.findById(rentalId);
    }

    public void deleteRental(final long rentalId) {
        rentalRepository.deleteById(rentalId);
    }

    public void finishRental(final long rentalId, final Long kilometersDone) {
        Rental rental = rentalRepository.findById(rentalId);
        rental.setKilometersDone(kilometersDone);
        double fuelLitresUsed = (kilometersDone/100.00) * rental.getCar().getConsumption();
        rental.setPrice(fuelLitresUsed * petrolFacade.countPetrolPricePerOneLitre());
        String carStatus = "available";
        Car newCarStatus = carFacade.getCar(rental.getCar().getId());
        newCarStatus.setStatus(carStatus);
    }
}
