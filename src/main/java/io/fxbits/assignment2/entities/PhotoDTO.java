package io.fxbits.assignment2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoDTO {
    private Integer size;
    private PhotoType type;
    private String venue;
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerUsername;
}
