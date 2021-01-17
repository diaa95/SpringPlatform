package com.diaa.authentication.repositories;

import com.diaa.authentication.models.Event;
import com.diaa.authentication.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    List<User> findAllByGoing(Event event);
}
