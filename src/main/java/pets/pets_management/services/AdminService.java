package pets.pets_management.services;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public void addNewSelections(SelectionInfo request) {
        Type type = new Type();
        FurColor furColor = new FurColor();
        Country country = new Country();
        if (!request.getType().isEmpty()) {
            String newType = (request.getType().substring(0, 1).toUpperCase() + request.getType().substring(1));
            boolean typeExists = typeRepository.existsBy(newType);
            ValidationService.validateSelectionExists(typeExists, newType, "type");
            type.setName(newType);
            typeRepository.save(type);
        }
        if (!request.getFurColor().isEmpty()) {
            String newFurColor = (request.getFurColor().substring(0, 1).toUpperCase() + request.getFurColor().substring(1));
            boolean furColorExists = furColorRepository.existsBy(newFurColor);
            ValidationService.validateSelectionExists(furColorExists, newFurColor, "fur color");
            furColor.setName(newFurColor);
            furColorRepository.save(furColor);
        }
        if (!request.getCountry().isEmpty()) {
            String newCountry = (request.getCountry().substring(0, 1).toUpperCase() + request.getCountry().substring(1));
            boolean countryExists = countryRepository.existsBy(newCountry);
            ValidationService.validateSelectionExists(countryExists, newCountry, "country");
            country.setName(newCountry);
            countryRepository.save(country);
        }
    }
}
