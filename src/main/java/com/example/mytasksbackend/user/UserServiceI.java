package com.example.mytasksbackend.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceI {
    List<User> findAll();
    User save(UserReq userReq);
}
