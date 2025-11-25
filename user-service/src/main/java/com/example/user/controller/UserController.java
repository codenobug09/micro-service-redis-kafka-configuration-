package com.example.user.controller;

import com.example.user.model.User;
import com.example.user.service.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceInterface userService;

    @PostMapping
    public User create(@RequestBody User u){
        return userService.create(u);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }


}
