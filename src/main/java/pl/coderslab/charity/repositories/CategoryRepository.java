package pl.coderslab.charity.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
