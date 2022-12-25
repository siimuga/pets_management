package pets.pets_management.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pets.pets_management.entities.UserData;

import java.util.List;
import java.util.Optional;

public interface UserDataRepository extends JpaRepository<UserData, Integer> {

    @Query("select (count(u) > 0) from UserData u where u.username = ?1 and u.password = ?2")
    boolean existsBy(String username, String password);

    @Query("select (count(u) > 0) from UserData u where u.username = ?1")
    boolean existsByUsername(String username);

    @Query("select u from UserData u where u.username = ?1")
    Optional<UserData> findByUsername(String username);

    @Query("select u from UserData u where u.username not like ?1 order by u.username")
    List<UserData> findAllUsers(String username);
}


