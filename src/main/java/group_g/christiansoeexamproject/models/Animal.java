package group_g.christiansoeexamproject.models;
import javax.persistence.*;
import java.util.List;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;

    @ElementCollection
    private List<Object> images;
    @ElementCollection
    private List<Object> sounds;




    public Animal(String title, String description, List<Object> images, List<Object> sounds){
        this.title = title;
        this.description = description;
        this.images = images;
        this.sounds = sounds;
    }

    public Animal(){

    }

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Object> getImage() {
        return images;
    }

    public void setImage(List<Object> images) {
        this.images = images;
    }

    public List<Object> getSound() {
        return sounds;
    }

    public void setSound(List<Object> sounds) {
        this.sounds = sounds;
    }
}
