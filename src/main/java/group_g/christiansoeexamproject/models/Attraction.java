package group_g.christiansoeexamproject.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Attraction extends Location {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "locations")
    @JsonIgnoreProperties("locations")
    private List<Animal> animals;


    public Attraction (String title, String report, double longitude, double latitude,
                        List<Animal> animals, List<Image> images, List<Sound> sounds){
        super(title, report, longitude, latitude,images, sounds);
        this.animals = animals;
    }

    public Attraction(){}

    public Long getId(){
        return id;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
