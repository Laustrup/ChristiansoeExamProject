package group_g.christiansoeexamproject.repositories;

import group_g.christiansoeexamproject.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {}
