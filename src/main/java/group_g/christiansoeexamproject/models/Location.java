package group_g.christiansoeexamproject.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="location")
public abstract class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private String report;
    @Column
    private double longitude;
    @Column
    private double latitude;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Image> images;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Sound> sounds;

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<TourLocation> tourLocations;


    public Location(String title, String report, double longitude, double latitude, List<Image> images, List<Sound> sounds){
        this.title = title;
        this.report = report;
        this.images = images;
        this.sounds = sounds;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location(){

    }

    public Long getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Sound> getSounds() {
        return sounds;
    }

    public void setSounds(List<Sound> sounds) {
        this.sounds = sounds;
    }

    public List<TourLocation> getTourLocations(){
        return tourLocations;
    }

    public void setTours(List<TourLocation> tourLocations){
        this.tourLocations = tourLocations;
    }
}
