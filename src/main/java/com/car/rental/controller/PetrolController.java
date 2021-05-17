package com.car.rental.controller;

import com.car.rental.facade.PetrolFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/petrol")
public class PetrolController {

    private final PetrolFacade petrolFacade;

    @GetMapping(value = "/price")
    public Double getPetrolPrices() {
        return petrolFacade.getPetrolPriceDolarPerGalon();
    }

}
