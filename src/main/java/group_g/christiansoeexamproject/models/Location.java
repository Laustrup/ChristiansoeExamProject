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
    private String report;
    @Column
    private String longitude;
    @Column
    private String latitude;

    @OneToMany
    private List<Image> images;



    public Location(String title, String report, List<Image> images, String longitude, String latitude){
        this.title = title;
        this.report = report;
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

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
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
