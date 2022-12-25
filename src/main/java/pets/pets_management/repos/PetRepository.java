package pets.pets_management.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pets.pets_management.entities.Pet;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    @Query("select p from Pet p where p.isActive = true")
    List<Pet> findAllActive();

   /* @Query("select p from Pet p where p.userData.id = ?1 order by p.name")
    List<Pet> findAllByUser(Integer id);*/

    @Query("select p from Pet p where p.isActive = true and p.userData.id = ?1 order by p.name")
    List<Pet> findAllByUser(Integer id);

    @Query("select count(p) from Pet p where p.userData.username = ?1")
    long countByUsername(String username);

    @Query("select count(p) from Pet p where p.userData.username = ?1 and p.isActive = true")
    long countActiveByUsername(String username);



}
