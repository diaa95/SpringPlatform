package com.diaa.authentication.repositories;

import com.diaa.authentication.models.Event;
import com.diaa.authentication.models.Message;
import com.diaa.authentication.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findAll();
    List<Message> findByEvent(Event event);
    List<Message> findByUser(User user);
}
