package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entities.User;

import java.lang.annotation.Native;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users INNER JOIN users_roles ON users.id = users_roles.user_id " +
            "WHERE users_roles.roles_id=2", nativeQuery = true)
    List<User> findAllAdmins();
}
