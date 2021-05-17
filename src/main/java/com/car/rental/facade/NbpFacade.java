package com.car.rental.facade;

import com.car.rental.domain.dolar.DolarRate;
import com.car.rental.nbpconfig.NbpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NbpFacade {

    private final NbpClient nbpClient;

    public Double getDolarRate() {
        DolarRate dolarRate = nbpClient.getDolarRate();
        return dolarRate.rates[0].getMid();
    }
}
