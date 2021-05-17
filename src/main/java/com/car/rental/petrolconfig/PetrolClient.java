package com.car.rental.petrolconfig;

import com.car.rental.domain.petrol.Petrol;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class PetrolClient {

    private final PetrolConfig petrolConfig;
    private final RestTemplate restTemplate;

    public URI getUrl() {
        return UriComponentsBuilder.fromHttpUrl(petrolConfig.getPetrolPriceEndpoint() + petrolConfig.getPetrolApiKey())
                .queryParam("series_id", petrolConfig.getPetrolEndpointParam())
                .build()
                .encode()
                .toUri();
    }

    public Petrol getPetrolPrices() {
        return restTemplate.getForObject(getUrl(), Petrol.class);
    }
}
