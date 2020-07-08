package io.fxbits.assignment2.service;

import io.fxbits.assignment2.entities.Photo;
import io.fxbits.assignment2.entities.PhotoDTO;
import io.fxbits.assignment2.entities.User;
import io.fxbits.assignment2.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    private List<PhotoDTO> toPhotoDTO(List<Photo> listPhoto){
        List<PhotoDTO> photoDTOList=new ArrayList<>();
        for (Photo photo : listPhoto) {
            photoDTOList.add(new PhotoDTO(photo.getSize(),photo.getType(),photo.getVenue(),photo.getUser().getFirstName(),
                    photo.getUser().getLastName(),photo.getUser().getUsername()));
        }
        return photoDTOList;
    }

    public List<Photo> findAllPhotos(){
        return photoRepository.findAll();
    }

    public List<PhotoDTO> findPhotosByVenue(String venue){
        return toPhotoDTO(photoRepository.findAllByVenue(venue));
    }

    public void savePhoto(Photo photo){
        photoRepository.save(photo);
    }

    public List<PhotoDTO> getPhotosPaginated(int page){
        Page<Photo> all = photoRepository.findAll(PageRequest.of(page-1, 10));
        return toPhotoDTO(all.getContent());
    }

    public List<PhotoDTO> findPhotosByUser(Long idUser) {
        return toPhotoDTO(photoRepository.findAllByUsersId(idUser));
    }
}
