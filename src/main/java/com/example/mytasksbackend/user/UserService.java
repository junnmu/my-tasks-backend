package com.example.mytasksbackend.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class UserService implements UserServiceI {
    private UserRepository userRepository;
    private UserConfig userConfig;

    public UserService(UserRepository userRepository, UserConfig userConfig) {
        this.userRepository = userRepository;
        this.userConfig = userConfig;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(UserReq userReq) {
        if (userConfig.getMaxNumber() == userRepository.count()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "cannot create new users");
        }
        if (userRepository.existsByEmail(userReq.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "email already exists");
        }

        return userRepository.save(new User(userReq.getName(), userReq.getEmail(), userReq.getPassword()));
    }
}
