package group_g.christiansoeexamproject.models;
import javax.persistence.*;
import java.util.List;

@Entity
public abstract class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private String longitude;
    private String latitude;

    @ElementCollection
    private List<Object> images;



    public Location(String title, String description, List<Object> images, String longitude, String latitude){
        this.title = title;
        this.description = description;
        this.images = images;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location(){

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

    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
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
