package pets.pets_management.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pets.pets_management.entities.Pet;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    @Query("select p from Pet p where p.isActive = true and p.userData.id = ?1 order by p.name")
    List<Pet> findAllByUserByNameAsc(Integer id);

    @Query("select p from Pet p where p.isActive = true and p.userData.id = ?1 order by p.name DESC")
    List<Pet> findAllByUserByNameDesc(Integer id);

    @Query("select p from Pet p where p.isActive = true and p.userData.id = ?1 order by p.code")
    List<Pet> findAllByUserByCodeAsc(Integer id);

    @Query("select p from Pet p where p.isActive = true and p.userData.id = ?1 order by p.code DESC")
    List<Pet> findAllByUserByCodeDesc(Integer id);

    @Query("select p from Pet p where p.isActive = true and p.userData.id = ?1 order by p.type.name")
    List<Pet> findAllByUserByTypeAsc(Integer id);

    @Query("select p from Pet p where p.isActive = true and p.userData.id = ?1 order by p.type.name DESC")
    List<Pet> findAllByUserByTypeDesc(Integer id);

    @Query("select p from Pet p where p.isActive = true and p.userData.id = ?1 order by p.furColor.name")
    List<Pet> findAllByUserByFurColorAsc(Integer id);

    @Query("select p from Pet p where p.isActive = true and p.userData.id = ?1 order by p.furColor.name DESC")
    List<Pet> findAllByUserByFurColorDesc(Integer id);

    @Query("select p from Pet p where p.isActive = true and p.userData.id = ?1 order by p.country.name")
    List<Pet> findAllByUserByCountryAsc(Integer id);

    @Query("select p from Pet p where p.isActive = true and p.userData.id = ?1 order by p.country.name DESC")
    List<Pet> findAllByUserByCountryDesc(Integer id);

    @Query("select count(p) from Pet p where p.userData.username = ?1")
    long countByUsername(String username);

    @Query("select count(p) from Pet p where p.userData.username = ?1 and p.isActive = true")
    long countActiveByUsername(String username);

    @Query("select p from Pet p where p.isActive = true order by p.name")
    List<Pet> findAllByNameAsc();

    @Query("select p from Pet p where p.isActive = true order by p.name DESC")
    List<Pet> findAllByNameDesc();

    @Query("select p from Pet p where p.isActive = true order by p.code")
    List<Pet> findAllByCodeAsc();

    @Query("select p from Pet p where p.isActive = true order by p.code DESC")
    List<Pet> findAllByCodeDesc();

    @Query("select p from Pet p where p.isActive = true order by p.type.name")
    List<Pet> findAllByTypeAsc();

    @Query("select p from Pet p where p.isActive = true order by p.type.name DESC")
    List<Pet> findAllByTypeDesc();

    @Query("select p from Pet p where p.isActive = true order by p.furColor.name")
    List<Pet> findAllByFurColorAsc();

    @Query("select p from Pet p where p.isActive = true order by p.furColor.name DESC")
    List<Pet> findAllByFurColorDesc();

    @Query("select p from Pet p where p.isActive = true order by p.country.name")
    List<Pet> findAllByCountryAsc();

    @Query("select p from Pet p where p.isActive = true order by p.country.name DESC")
    List<Pet> findAllByCountryDesc();

    @Query("select p from Pet p where p.isActive = true order by p.userData.username")
    List<Pet> findAllByOwnerAsc();

    @Query("select p from Pet p where p.isActive = true order by p.userData.username DESC")
    List<Pet> findAllByOwnerDesc();
}
