package pets.pets_management;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import pets.pets_management.dto.CountryInfo;
import pets.pets_management.dto.FurColorInfo;
import pets.pets_management.dto.TypeInfo;
import pets.pets_management.entities.*;
import pets.pets_management.mappers.CountryMapper;
import pets.pets_management.mappers.FurColorMapper;
import pets.pets_management.mappers.TypeMapper;
import pets.pets_management.repos.*;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Resource
    private PetRepository petRepository;

    @Resource
    private CountryRepository countryRepository;

    @Resource
    private FurColorRepository furColorRepository;

    @Resource
    private TypeRepository typeRepository;

    @Resource
    private UserDataRepository userDataRepository;

    @Resource
    private PetMapper petMapper;

    @Resource
    private TypeMapper typeMapper;

    @Resource
    private FurColorMapper furColorMapper;

    @Resource
    private CountryMapper countryMapper;
    public void addPet(PetRequest request) {
        Pet pet = new Pet();
        pet.setName(request.getName());
        pet.setCode(request.getCode());
        Type byType = typeRepository.findByName(request.getType());
        pet.setType(byType);
        FurColor byFurColor = furColorRepository.findByName(request.getFurColor());
        pet.setFurColor(byFurColor);
        Country byCountry = countryRepository.findByName(request.getCountry());
        pet.setCountry(byCountry);
        Optional<UserData> user = userDataRepository.findById(request.getUserId());
        pet.setUserData(user.get());
        petRepository.save(pet);
    }

    public List<PetInfo> findAllPets() {
        List<Pet> pets = petRepository.findAllActive();
        List<PetInfo> petInfos =  petMapper.petsToPetInfos(pets);
        for (PetInfo petInfo : petInfos) {
            petInfo.setSeqNr(petInfos.indexOf(petInfo) + 1);
        }
        return petInfos;
    }

    public List<TypeInfo> findAllTypes() {
        List<Type> types = typeRepository.findAll();
        return typeMapper.typesToTypeInfos(types);
    }

    public List<FurColorInfo> findAllFurColors() {
        Iterable<FurColor> furColors = furColorRepository.findAll();
        return furColorMapper.furColorsToFurColorInfos(furColors);
    }

    public List<CountryInfo> findAllCountries() {
        Iterable<Country> countries = countryRepository.findAll();
        return countryMapper.countriesToCountryInfos(countries);
    }

    public void updatePet(PetInfo request) {
        Optional<Pet> pet = petRepository.findById(request.getId());
        pet.get().setName(request.getName());
        pet.get().setCode(request.getCode());
        Type newType = typeRepository.findByName(request.getType());
        pet.get().setType(newType);
        FurColor newFurColor = furColorRepository.findByName(request.getFurColor());
        pet.get().setFurColor(newFurColor);
        Country newCountry = countryRepository.findByName(request.getCountry());
        pet.get().setCountry(newCountry);
        petRepository.save(pet.get());
    }

    public void deletePet(Integer petId) {
        Optional<Pet> pet = petRepository.findById(petId);
        pet.get().setIsActive(false);
        petRepository.save(pet.get());
    }
    public List<PetInfo> findAllPetsByUser(Integer userId) {
        List<Pet> pets = petRepository.findAllByUser(userId);
        List<PetInfo> petInfos =  petMapper.petsToPetInfos(pets);
        for (PetInfo petInfo : petInfos) {
            petInfo.setSeqNr(petInfos.indexOf(petInfo) + 1);
        }
        return petInfos;
    }
}
