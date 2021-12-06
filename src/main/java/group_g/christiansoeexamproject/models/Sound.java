package group_g.christiansoeexamproject.models;

import javax.persistence.*;

@Entity
@Table(name="sound")
public class Sound {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String filePath;

    @ManyToOne
    @JoinColumn(name="sound_animal")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name="sound_location")
    private Location location;


    public Sound (String filePath){
        this.filePath = filePath;
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
}
