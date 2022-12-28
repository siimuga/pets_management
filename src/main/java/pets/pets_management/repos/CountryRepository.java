package pets.pets_management.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pets.pets_management.entities.Country;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Integer> {
    @Query("select c from Country c order by c.name")
    List<Country> findAllOrdered();

    @Query("select c from Country c where c.name = ?1")
    Country findByName(String name);

}
