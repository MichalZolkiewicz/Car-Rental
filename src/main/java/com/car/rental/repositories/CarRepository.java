package com.car.rental.repositories;

import com.car.rental.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    Car findById(long id);

    List<Car> findAll();
}
