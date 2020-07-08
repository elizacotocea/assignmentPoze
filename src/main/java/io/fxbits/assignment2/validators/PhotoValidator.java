package io.fxbits.assignment2.validators;

import io.fxbits.assignment2.entities.Photo;
import io.fxbits.assignment2.entities.PhotoType;

public class PhotoValidator implements Validator<Photo>{

    @Override
    public void validate(Photo entity) throws ValidatorException {
        if ((entity.getType().equals(PhotoType.jpeg) && entity.getSize()>230) || (entity.getType().equals(PhotoType.png) && entity.getSize()>150))
            throw new ValidatorException("Photo size is too big!");

    }
}
