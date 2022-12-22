package pets.pets_management.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pets.pets_management.dto.FurColorInfo;
import pets.pets_management.entities.FurColor;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FurColorMapper {

    FurColorInfo furColorToFurColorInfo(FurColor furColor);

    List<FurColorInfo> furColorsToFurColorInfos(Iterable<FurColor> furColors);
}
