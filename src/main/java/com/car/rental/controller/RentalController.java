package com.car.rental.controller;

import com.car.rental.domain.RentalDto;
import com.car.rental.facade.RentalFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class RentalController {

    private final RentalFacade rentalFacade;

    @GetMapping(value = "/rentals")
    public List<RentalDto> getAllRentals() {
        return rentalFacade.getAllRental();
    }

    @GetMapping(value = "/rentals/{rentalId}")
    public RentalDto getRental(@PathVariable Long rentalId) {
        return rentalFacade.getRentalDto(rentalId);
    }

    @PostMapping(value = "/rentals")
    public Long createRental(@RequestBody RentalDto rentalDto) {
        return rentalFacade.saveRental(rentalDto);
    }

    @PutMapping(value = "rentals/{rentalId}")
    public void finishRental(@PathVariable Long rentalId, @RequestParam Long kilometersDone) {
        rentalFacade.finishRental(rentalId, kilometersDone);
    }

    @DeleteMapping(value = "rentals/{rentalId}")
    public void deleteRental(@PathVariable Long rentalId) {
        rentalFacade.deleteRental(rentalId);
    }
}
