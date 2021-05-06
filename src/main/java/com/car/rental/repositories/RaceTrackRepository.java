package com.car.rental.repositories;

import com.car.rental.domain.RaceTrack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface RaceTrackRepository extends CrudRepository<RaceTrack, Long> {

    List<RaceTrack> findAll();

    RaceTrack findById(final long id);
}
