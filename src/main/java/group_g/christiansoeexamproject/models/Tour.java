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
    private String description;

   @OneToMany
    private List<Location> locations;

    public Tour (String title, String description, List<Location> locations){
        this.title = title;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
