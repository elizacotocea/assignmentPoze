package io.fxbits.assignment2.controller;

import io.fxbits.assignment2.entities.Photo;
import io.fxbits.assignment2.entities.User;
import io.fxbits.assignment2.repository.PhotoRepository;
import io.fxbits.assignment2.repository.UserRepository;
import io.fxbits.assignment2.service.PhotoService;
import io.fxbits.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    List<User> users(){
        return userService.findAllUsers();
    }

    @PostMapping(value = "/users", consumes = "application/json")
    void save(@RequestBody User user) {
        userService.saveUser(user);
    }
    }
