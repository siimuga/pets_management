package pets.pets_management;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import pets.pets_management.dto.*;
import pets.pets_management.services.AdminService;
import pets.pets_management.services.LoginService;
import pets.pets_management.services.PetService;
import pets.pets_management.services.UserDataService;

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

    @Resource
    private AdminService adminService;

    @PostMapping("pet")
    public void addPet(@RequestBody PetRequest request) {petService.addPet(request);}

    @GetMapping("/code")
    public Integer getNewCode(@RequestParam Integer userId) {
        return petService.getNewCode(userId);
    }

    @GetMapping("pets/sort")
    public List<PetInfo> findAllPetsSorted(@RequestParam String sort) {
        return petService.findAllPetsSorted(sort);
    }

    @PostMapping("selection")
    public void addNewSelections(@RequestBody SelectionInfo request) {
        adminService.addNewSelections(request);
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
