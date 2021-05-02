package com.car.rental.repositories;

import com.car.rental.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findById(long id);
}
