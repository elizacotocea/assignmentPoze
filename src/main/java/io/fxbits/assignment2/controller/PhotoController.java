package io.fxbits.assignment2.controller;

import io.fxbits.assignment2.entities.Photo;
import io.fxbits.assignment2.entities.User;
import io.fxbits.assignment2.service.PhotoService;
import io.fxbits.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @GetMapping("/photos")
    List<Photo> hello(){
        return photoService.findAllPhotos();
    }

    @PostMapping(value = "/photos", consumes = "application/json")
    void save(@RequestBody Photo photo) {
        photoService.savePhoto(photo);
    }
}
