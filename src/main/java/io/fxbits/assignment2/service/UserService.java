package io.fxbits.assignment2.service;
import io.fxbits.assignment2.entities.Photo;
import io.fxbits.assignment2.entities.User;
import io.fxbits.assignment2.repository.UserRepository;
import io.fxbits.assignment2.validators.UserValidator;
import io.fxbits.assignment2.validators.UsernameValidator;
import io.fxbits.assignment2.validators.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UsernameValidator usernameValidator;
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user) throws ValidatorException {
        return userRepository.save(user);}
    public List<User> sortByLastnameDesc(){
        return userRepository.findAllByOrderByLastNameDesc();
    }

    public List<User> sortByFirstNameDesc() {
        return userRepository.findAllByOrderByFirstNameDesc();
    }

    public List<User> sortByUsernameDesc() {
        return userRepository.findAllByOrderByUsernameDesc();
    }

    public List<User> sortByFirstNameAsc() {
        return userRepository.findAllByOrderByFirstNameAsc();
    }

    public List<User> sortByLastnameAsc() {
        return userRepository.findAllByOrderByLastNameAsc();
    }

    public List<User> sortByUsernameAsc() {
        return userRepository.findAllByOrderByUsernameAsc();
    }

    public List<User> findByFirstName(String firstname){
        User user=new User();
        user.setFirstName(firstname);
        ExampleMatcher matcher=ExampleMatcher.matchingAny().withMatcher("venue",ExampleMatcher.GenericPropertyMatchers.exact());
        Example<User> userExample = Example.of(user, matcher);
        return userRepository.findAll(userExample);
    }
}
