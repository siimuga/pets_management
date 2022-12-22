package pets.pets_management.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pets.pets_management.dto.TypeInfo;
import pets.pets_management.entities.Type;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TypeMapper {

    TypeInfo typeToTypeInfo(Type type);
    List<TypeInfo> typesToTypeInfos(List<Type> types);
}
