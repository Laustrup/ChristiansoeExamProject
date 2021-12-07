package group_g.christiansoeexamproject.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="sound")
public class Sound {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String filePath;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name="sound_animal")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name="sound_location")
    private Location location;

    //Dette skaber et ekstra table hvor to klasser joiner, og giver det mening? Det passer ikke med ER. sound_locations findes ikke!
    @ManyToMany
    @JoinColumn(name="sound_locations")
    private List<Location> locations;

    public Sound (String title, String filePath){
        this.filePath = filePath;
        this.title = title;
    }

    public Sound(){

    }


    public Long getId(){
        return id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Animal getAnimal(){
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
