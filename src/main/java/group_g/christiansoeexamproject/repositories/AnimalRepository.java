package group_g.christiansoeexamproject.repositories;

import group_g.christiansoeexamproject.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {}
