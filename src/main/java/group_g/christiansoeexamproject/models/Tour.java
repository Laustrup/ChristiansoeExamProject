package group_g.christiansoeexamproject.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tour")
public class Tour {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private String report;

    @OneToMany(mappedBy = "tour", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<TourLocation> tourLocations;


    public Tour (String title, String report, List<TourLocation> tourLocations){
        this.title = title;
        this.report = report;
        this.tourLocations = tourLocations;
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

    public List<TourLocation> getTourLocations() {
        return tourLocations;
    }

    public void setTourLocations(List<TourLocation> tourLocations) {
        this.tourLocations = tourLocations;
    }
}
