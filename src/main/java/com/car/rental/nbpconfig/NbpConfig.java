package com.car.rental.nbpconfig;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class NbpConfig {

    @Value("http://api.nbp.pl/api/exchangerates/rates/a/usd")
    private String usdRateEndpoint;

}
