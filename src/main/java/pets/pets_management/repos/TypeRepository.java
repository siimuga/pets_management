package pets.pets_management.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pets.pets_management.entities.Type;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Integer> {

    @Query("select t from Type t order by t.name")
    List<Type> findAllOrdered();
    @Query("select t from Type t where t.name = ?1")
    Type findByName(String name);
}


