package com.car.rental.repositories;

import com.car.rental.domain.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface RentalRepository extends CrudRepository<Rental, Long> {

    List<Rental> findAll();

    Rental findById(long id);
}
