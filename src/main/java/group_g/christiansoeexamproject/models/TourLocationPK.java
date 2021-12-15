package group_g.christiansoeexamproject.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TourLocationPK implements Serializable {

    private Long tour_id;
    private Long location_id;

    public Long getTour_id() {
        return tour_id;
    }

    public void setTour_id(Long tour_id) {
        this.tour_id = tour_id;
    }

    public Long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
