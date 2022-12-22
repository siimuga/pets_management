package pets.pets_management.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pets.pets_management.dto.CountryInfo;
import pets.pets_management.entities.Country;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CountryMapper {

    CountryInfo countryToCountryInfo(Country country);
    List<CountryInfo> countriesToCountryInfos(Iterable<Country> countries);
}
