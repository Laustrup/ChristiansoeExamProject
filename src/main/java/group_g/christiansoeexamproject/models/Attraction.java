package group_g.christiansoeexamproject.models;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Attraction extends Location {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "images")
    @JsonBackReference
    private List<Animal> animals;

    @OneToMany(mappedBy = "location")
    @JsonBackReference
    private List<Sound> sounds;


    public Attraction (String title, String report, double longitude, double latitude,
                        List<Animal> animals, List<Sound> sounds, List<Image> images){
        super(title, report, longitude, latitude,images);
        this.animals = animals;
        this.sounds = sounds;
    }

    public Attraction(){

    }

    public Long getId(){
        return id;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Sound> getSounds() {
        return sounds;
    }

    public void setSounds(List<Sound> sounds) {
        this.sounds = sounds;
    }
}
