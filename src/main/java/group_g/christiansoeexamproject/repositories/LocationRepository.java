package group_g.christiansoeexamproject.repositories;

import group_g.christiansoeexamproject.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {}