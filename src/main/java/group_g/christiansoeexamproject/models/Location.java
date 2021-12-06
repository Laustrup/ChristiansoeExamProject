package group_g.christiansoeexamproject.models;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="location")
public abstract class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;
    @Column
    private String report;
    @Column
    private String longitude;
    @Column
    private String latitude;

    @OneToMany(mappedBy = "location")
    @JsonBackReference
    private List<Image> images;

    @OneToMany(mappedBy = "location")
    @JsonBackReference
    private List<Sound> sounds;

    @ManyToMany(mappedBy = "locations")
    private List<Tour> tours;


    public Location(String title, String report, String longitude, String latitude){
        this.title = title;
        this.report = report;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Sound> getSounds(){
        return sounds;
    }

    public void setSounds(List<Sound> sounds){
        this.sounds = sounds;
    }

    public List<Tour> getTours(){
        return tours;
    }

    public void setTours(List<Tour> tours){
        this.tours = tours;
    }
}
