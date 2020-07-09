package io.fxbits.assignment2.controller;

import io.fxbits.assignment2.entities.Photo;
import io.fxbits.assignment2.entities.PhotoDTO;
import io.fxbits.assignment2.entities.User;
import io.fxbits.assignment2.service.PhotoService;
import io.fxbits.assignment2.service.UserService;
import io.fxbits.assignment2.validators.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @GetMapping("/")
    List<Photo> findAllPhotos(){
        return photoService.findAllPhotos();
    }

    @PostMapping(value = "/photos", consumes = "application/json")
    void save(@RequestBody Photo photo) throws ValidatorException {
        photoService.savePhoto(photo);
    }

    @RequestMapping(value = "/photos", params = "page")
    List<PhotoDTO> photosPaginated(@RequestParam("page") int page){
        return photoService.getPhotosPaginated(page);
    }

    @RequestMapping(value = "/photos", params = "venue")
    List<PhotoDTO> photosByVenue(@RequestParam("venue") String venue){
        return photoService.findPhotosByVenue(venue);
    }

    @RequestMapping(value = "/photos", params = "idUser")
    List<PhotoDTO> photosByIdUser(@RequestParam("idUser") Long idUser){
        return photoService.findPhotosByUser(idUser);
    }
}
