package group_g.christiansoeexamproject.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String filePath;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name="image_animal")
    @JsonManagedReference
    private Animal animal;

    @ManyToOne
    @JoinColumn(name="image_location")
    @JsonManagedReference
    private Location location;


    public Image (String title, String filePath){
        this.filePath = filePath;
        this.title = title;
    }

    public Image(){

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

    public Location getLocation(){
        return location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
