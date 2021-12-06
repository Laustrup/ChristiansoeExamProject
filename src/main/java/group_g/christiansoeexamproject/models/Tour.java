package group_g.christiansoeexamproject.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tour")
public class Tour {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;
    @Column
    private String report;

   @ManyToMany
    @JoinColumn(name="tour_location")
    private List<Location> locations;


    public Tour (String title, String report, List<Location> locations){
        this.title = title;
        this.report = report;
        this.locations = locations;
    }

    public Tour(){

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

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
