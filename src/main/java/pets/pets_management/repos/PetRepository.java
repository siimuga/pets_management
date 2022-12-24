package pets.pets_management.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pets.pets_management.entities.Pet;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    @Query("select p from Pet p where p.isActive = true")
    List<Pet> findAllActive();

}
