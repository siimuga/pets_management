package pets.pets_management.services;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import pets.pets_management.dto.SelectionInfo;
import pets.pets_management.entities.Country;
import pets.pets_management.entities.FurColor;
import pets.pets_management.entities.Type;
import pets.pets_management.repos.CountryRepository;
import pets.pets_management.repos.FurColorRepository;
import pets.pets_management.repos.TypeRepository;

@Service
public class AdminService {

    @Resource
    TypeRepository typeRepository;

    @Resource
    FurColorRepository furColorRepository;

    @Resource
    CountryRepository countryRepository;
    public void addNewSelections(SelectionInfo request) {
        if (!request.getType().isEmpty()) {
            Type type = new Type();
            type.setName(request.getType().substring(0,1).toUpperCase() + request.getType().substring(1));
            typeRepository.save(type);
        }
        if (!request.getFurColor().isEmpty()) {
            FurColor furColor = new FurColor();
            furColor.setName(request.getFurColor().substring(0,1).toUpperCase() + request.getFurColor().substring(1));
            furColorRepository.save(furColor);
        }
        if (!request.getCountry().isEmpty()) {
            Country country = new Country();
            country.setName(request.getCountry().substring(0,1).toUpperCase() + request.getCountry().substring(1));
            countryRepository.save(country);
        }
    }
}
