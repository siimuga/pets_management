package pets.pets_management;

import lombok.Data;

@Data
public class UserInfo {
    private Integer seqNr;
    private String name;
    private String password;
    private Integer petsActive;
    private Integer petsDeactive;
}
