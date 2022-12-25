package pets.pets_management.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import pets.pets_management.entities.UserData;

public interface UserDataRepository extends JpaRepository<UserData, Integer> {
}


