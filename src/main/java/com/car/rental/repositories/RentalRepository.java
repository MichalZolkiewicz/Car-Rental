package com.car.rental.repositories;

import com.car.rental.domain.Rental;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<Rental, Long> {
}
