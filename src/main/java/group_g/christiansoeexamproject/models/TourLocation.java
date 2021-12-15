package group_g.christiansoeexamproject.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "tour_locations")
public class TourLocation {

    @EmbeddedId
    private TourLocationPK id;

    @ManyToOne
    @MapsId("tour_id")
    @JoinColumn(name = "tours_id")
    @JsonBackReference
    private Tour tour;

    @ManyToOne
    @MapsId("location_id")
    @JoinColumn(name = "locations_id")
    @JsonBackReference
    private Location location;

    @Column
    private int step;

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public TourLocationPK getId() {
        return id;
    }

    public void setId(TourLocationPK id) {
        this.id = id;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
