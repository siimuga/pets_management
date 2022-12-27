package pets.pets_management.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pets.pets_management.dto.UserInfo;
import pets.pets_management.entities.UserData;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserDataMapper {

    @Mapping(source = "username", target = "name")
    @Mapping(ignore = true, target = "seqNr")
    @Mapping(ignore = true, target = "petsActive")
    @Mapping(ignore = true, target = "petsDeactive")
    UserInfo userToUserInfo(UserData userData);
    List<UserInfo> usersToUserInfos(List<UserData> users);
}
