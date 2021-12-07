package group_g.christiansoeexamproject.repositories;

import group_g.christiansoeexamproject.models.Sound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoundRepository extends JpaRepository<Sound, Long> {}
