package group_g.christiansoeexamproject.models;
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
    private String description;
    @Column
    private String longitude;
    @Column
    private String latitude;

    @OneToMany
    private List<Image> images;



    public Location(String title, String description, List<Image> images, String longitude, String latitude){
        this.title = title;
        this.description = description;
        this.images = images;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
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
}
