package pets.pets_management.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pets.pets_management.entities.FurColor;

public interface FurColorRepository extends CrudRepository<FurColor, Integer> {
    @Query("select f from FurColor f where f.name = ?1")
    FurColor findByName(String name);
}
