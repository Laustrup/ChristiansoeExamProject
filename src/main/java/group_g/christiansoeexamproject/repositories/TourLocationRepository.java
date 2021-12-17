package group_g.christiansoeexamproject.repositories;

import group_g.christiansoeexamproject.models.TourLocation;
import group_g.christiansoeexamproject.models.TourLocationPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourLocationRepository extends JpaRepository<TourLocation, TourLocationPK> {
}
