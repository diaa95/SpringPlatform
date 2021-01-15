package com.diaa.authentication.services;

import org.mindrot.jbcrypt.BCrypt;
import com.diaa.authentication.models.User;
import com.diaa.authentication.repositories.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
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
}
