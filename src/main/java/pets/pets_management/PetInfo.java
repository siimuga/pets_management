package pets.pets_management;

import lombok.Data;

@Data
public class PetInfo {
    private Integer seqNr;
    private String name;
    private Integer code;
    private String type;
    private String furColor;
    private String country;
}