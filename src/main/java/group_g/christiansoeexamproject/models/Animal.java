package group_g.christiansoeexamproject.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;
    @Column
    private String description;


    @OneToMany
    private List<Image> images;
    @OneToMany
    private List<Sound> sounds;




    public Animal(String title, String description, List<Image> images, List<Sound> sounds){
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

    public List<Image> getImage() {
        return images;
    }

    public void setImage(List<Image> images) {
        this.images = images;
    }

    public List<Sound> getSound() {
        return sounds;
    }

    public void setSound(List<Sound> sounds) {
        this.sounds = sounds;
    }
}
