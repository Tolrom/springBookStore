package com.tolrom.springlibrary.service;

import com.tolrom.springlibrary.model.User;
import com.tolrom.springlibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Fetches every user
    public Iterable<User> findAllUsers() {
        if(userRepository.count() == 0) {
            return null;
        }
        return userRepository.findAll();
    }

    // Fetches a user by its ID
    public Optional<User> findUserById(Integer id) {
        return Optional.of(userRepository.findById(id).orElse(new User()));
    }
}
