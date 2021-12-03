package group_g.christiansoeexamproject.models;
import javax.persistence.*;
import java.util.List;

@Entity
public class Attraction extends Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    private List<Object> animals;
    @ElementCollection
    private List<Object> sounds;

    public Attraction (List<Object> animals, List<Object> sounds){
        this.animals = animals;
        this.sounds = sounds;
    }

    public Attraction(){

    }

    public Long getId(){
        return id;
    }

    public List<Object> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Object> animals) {
        this.animals = animals;
    }

    public List<Object> getSounds() {
        return sounds;
    }

    public void setSounds(List<Object> sounds) {
        this.sounds = sounds;
    }
}
