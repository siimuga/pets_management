package pets.pets_management;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import pets.pets_management.entities.UserData;

@Service
public class LoginService {

    @Resource
    UserDataService userDataService;
    public Integer logIn(UserRequest request) {
        return userDataService.getValidUser(request);
    }

    public void registerNewUser(UserRequest request) {
        userDataService.registerNewUser(request);
    }
}
