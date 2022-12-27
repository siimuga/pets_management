package pets.pets_management.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequest {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
