package pets.pets_management.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pets.pets_management.dto.PetInfo;
import pets.pets_management.entities.Pet;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PetMapper {

    @Mapping(source = "type.name", target = "type")
    @Mapping(source = "furColor.name", target = "furColor")
    @Mapping(source = "country.name", target = "country")
    @Mapping(source = "userData.username", target = "owner")
    @Mapping(ignore = true, target = "seqNr")
    PetInfo petToPetInfo(Pet pet);

    List<PetInfo> petsToPetInfos(List<Pet> pets);
}
