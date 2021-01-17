package com.diaa.authentication.repositories;

import com.diaa.authentication.models.Event;
import com.diaa.authentication.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAll();
    List<Event> findByState(String state);
    List<Event> findByStateNot(String state);
    List<Event> findByHost(User host);
}
