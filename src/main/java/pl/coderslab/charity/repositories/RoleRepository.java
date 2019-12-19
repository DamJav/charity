package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getByName(String name);

}
