package io.fxbits.assignment2.service;

import io.fxbits.assignment2.entities.Photo;
import io.fxbits.assignment2.entities.User;
import io.fxbits.assignment2.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> findAllPhotos(){
        return photoRepository.findAll();
    }

    public void savePhoto(Photo photo){
        photoRepository.save(photo);
    }
}
