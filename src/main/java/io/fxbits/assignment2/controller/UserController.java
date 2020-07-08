package io.fxbits.assignment2.controller;

import io.fxbits.assignment2.entities.Photo;
import io.fxbits.assignment2.entities.PhotoDTO;
import io.fxbits.assignment2.entities.User;
import io.fxbits.assignment2.repository.PhotoRepository;
import io.fxbits.assignment2.repository.UserRepository;
import io.fxbits.assignment2.service.PhotoService;
import io.fxbits.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users", consumes = "application/json")
    void save(@RequestBody User user) {
        userService.saveUser(user);
    }

    @RequestMapping(value="/users/{sortType}/by/{sortingField}", method = RequestMethod.GET)
    public List<User> sortedUsers(@PathVariable String sortType, @PathVariable String sortingField){
        if (sortType.equals("desc"))
            switch (sortingField) {
                case ("lastname"):
                    return userService.sortByLastnameDesc();
                case ("firstname"):
                    return userService.sortByFirstNameDesc();
                case ("username"):
                    return userService.sortByUsernameDesc();
            }
        else if (sortType.equals("asc"))
            switch (sortingField) {
                case ("lastname"):
                    return userService.sortByLastnameAsc();
                case ("firstname"):
                    return userService.sortByFirstNameAsc();
                case ("username"):
                    return userService.sortByUsernameAsc();
            }
        return null;
    }

    @GetMapping("/users")
    List<User> getbyFirstname(@RequestParam String firstname){
        return userService.findByFirstName(firstname);
    }
    }
