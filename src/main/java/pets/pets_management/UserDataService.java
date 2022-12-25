package pets.pets_management;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import pets.pets_management.entities.UserData;
import pets.pets_management.mappers.UserDataMapper;
import pets.pets_management.repos.PetRepository;
import pets.pets_management.repos.UserDataRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {

    @Resource
    UserDataRepository userDataRepository;

    @Resource
    UserDataMapper userDataMapper;

    @Resource
    PetRepository petRepository;

    public Integer getValidUser(UserRequest request) {
        if (request.getUsername().isBlank() || request.getPassword().isBlank()) {
            ValidationService.validatePasswordUserExists(false);
        }
        boolean userExists = userDataRepository.existsBy(request.getUsername(), request.getPassword());
        ValidationService.validatePasswordUserExists(userExists);
        Optional<UserData> byUsername = userDataRepository.findByUsername(request.getUsername());
        return byUsername.get().getId();
    }

    public void registerNewUser(UserRequest request) {
        if (request.getUsername().isBlank() || request.getPassword().isBlank()) {
            ValidationService.validateUserCreation(request.getUsername().isBlank(),request.getPassword().isBlank());
        }
        boolean userExists = userDataRepository.existsByUsername(request.getUsername());
        ValidationService.validateUserExists(userExists);
        UserData userData = new UserData();
        userData.setUsername(request.getUsername());
        userData.setPassword(request.getPassword());
        userDataRepository.save(userData);
    }

    public List<UserInfo> findAllUsers() {
        List<UserData> users = userDataRepository.findAllUsers("admin");
        List<UserInfo> userInfos = userDataMapper.usersToUserInfos(users);
        for (UserInfo userInfo : userInfos) {
            userInfo.setSeqNr(userInfos.indexOf(userInfo) + 1);
            String name = userInfo.getName();
            long total = petRepository.countByUsername(name);
            long active = petRepository.countActiveByUsername(name);
            userInfo.setPetsActive((int) active);
            userInfo.setPetsDeactive((int) (total-active));
        }
        return userInfos;
    }
}
