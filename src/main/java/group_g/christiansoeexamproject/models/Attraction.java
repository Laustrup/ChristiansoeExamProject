package group_g.christiansoeexamproject.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="attraction")
public class Attraction extends Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Animal> animals;
    @OneToMany
    private List<Sound> sounds;

    public Attraction (List<Animal> animals, List<Sound> sounds){
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
