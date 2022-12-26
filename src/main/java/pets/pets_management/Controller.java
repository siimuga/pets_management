package pets.pets_management;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import pets.pets_management.dto.CountryInfo;
import pets.pets_management.dto.FurColorInfo;
import pets.pets_management.dto.TypeInfo;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class Controller {

    @Resource
    PetService petService;

    @Resource
    private LoginService loginService;

    @Resource
    private UserDataService userDataService;

    @PostMapping("pet")
    public void addPet(@RequestBody PetRequest request) {petService.addPet(request);}

    @GetMapping("pets/sort")
    public List<PetInfo> findAllPetsSorted(@RequestParam String sort) {
        return petService.findAllPetsSorted(sort);
    }

    @GetMapping("users")
    public List<UserInfo> findAllUsers() {return userDataService.findAllUsers();}

    @GetMapping("type")
    public List<TypeInfo> findAllTypes() {
        return petService.findAllTypes();
    }

    @GetMapping("furcolor")
    public List<FurColorInfo> findAllFurColors() {
        return petService.findAllFurColors();
    }

    @GetMapping("country")
    public List<CountryInfo> findAllCountries() {
        return petService.findAllCountries();
    }

    @PatchMapping("pet")
    public void updatePet(@RequestBody PetInfo request) {
        petService.updatePet(request);
    }

    @DeleteMapping("pet")
    public void deletePet(@RequestParam Integer petId) {
        petService.deletePet(petId);
    }

    @GetMapping("mypets/sort")
    public List<PetInfo> findAllPetsByUserSorted(@RequestParam Integer userId, @RequestParam String sort) {
        return petService.findAllPetsByUserSorted(userId, sort);
    }

    @PostMapping("/login")
    public Integer logIn(@RequestBody UserRequest request) {
        return loginService.logIn(request);
    }

    @PostMapping("/register")
    public void registerNewUser(@RequestBody UserRequest request) {
        loginService.registerNewUser(request);
    }

}
