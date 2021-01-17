package com.diaa.authentication.services;

import com.diaa.authentication.models.Event;
import com.diaa.authentication.models.Message;
import com.diaa.authentication.repositories.EventRepository;
import com.diaa.authentication.repositories.MessageRepository;
import jdk.jshell.EvalException;
import org.mindrot.jbcrypt.BCrypt;
import com.diaa.authentication.models.User;
import com.diaa.authentication.repositories.UserRepository;
import org.springframework.jmx.export.assembler.MBeanInfoAssembler;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final MessageRepository messageRepository;

    public UserService(UserRepository userRepository, EventRepository eventRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.messageRepository = messageRepository;
    }

    public User registerUser(User user){
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public User findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public boolean authenticateUser(String email, String password){
        User user = userRepository.findByEmail(email);
        if(user == null){
            return false;
        } else if(BCrypt.checkpw(password, user.getPassword())){
            return true;
        } else{ return false;}
    }
    public Event findEventById(Long id){
        return eventRepository.findById(id).orElse(null);
    }
    public Event addEvent(Event event, Long host_id){
        User host = userRepository.findById(host_id).orElse(null);
        event.setHost(host);
        return eventRepository.save(event);
    }
    public void deleteEventById(Long id){ eventRepository.deleteById(id); }
    public List<Event> hosted(User host){
        return eventRepository.findByHost(host);
    }
    public List<Event> EventsInState(String state){
        return eventRepository.findByState(state);
    }
    public List<Event> EventsNotInState(String state){
        return eventRepository.findByStateNot(state);
    }
    public void joinEvent(User user,Event event){
        List<User> attending = userRepository.findAllByGoing(event);
        attending.add(user);
        event.setUsers(attending);
        eventRepository.save(event);
    }
    public void cancel(Event event, User user){
        List<User> attending = userRepository.findAllByGoing(event);
        attending.remove(user);
        event.setUsers(attending);
        eventRepository.save(event);
    }
    public List<Message> findEventMessages(Event event){
        return messageRepository.findByEvent(event);
    }
    public Message addMessage(String context, User user,Event event){
        Message message = new Message();
        message.setContext(context);
        message.setEvent(event);
        message.setUser(user);
        return messageRepository.save(message);
    }

}
