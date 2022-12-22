package pets.pets_management.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import pets.pets_management.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
