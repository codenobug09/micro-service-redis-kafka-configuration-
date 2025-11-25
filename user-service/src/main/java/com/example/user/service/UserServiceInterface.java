package com.example.user.service;

import com.example.user.model.User;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface UserServiceInterface {
    User create(User u);

    List<User> findAll();
}
