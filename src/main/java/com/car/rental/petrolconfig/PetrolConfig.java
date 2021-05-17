package com.car.rental.petrolconfig;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PetrolConfig {

    @Value("https://api.eia.gov/series/")
    private String petrolPriceEndpoint;

    @Value("?api_key=c239a8c9825c7f51eebbb89ce5e8574f")
    private String petrolApiKey;

    @Value("PET.EMM_EPM0_PTE_NUS_DPG.W")
    private String petrolEndpointParam;
}
