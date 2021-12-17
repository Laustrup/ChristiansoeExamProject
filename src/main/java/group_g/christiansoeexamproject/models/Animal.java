package group_g.christiansoeexamproject.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private String report;


    @OneToMany(mappedBy = "animal", cascade =  CascadeType.ALL)
    @JsonManagedReference
    private List<Image> images;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Sound> sounds;

    @ManyToMany()
    @JoinColumn(name="animals")
    private List<Location> locations;



    public Animal(String title, String report, List<Image> images, List<Sound> sounds, List<Location> locations){
        this.title = title;
        this.report = report;
        this.images = images;
        this.sounds = sounds;
        this.locations = locations;
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

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Sound> getSounds() {
        return sounds;
    }

    public void setSounds(List<Sound> sounds) {
        this.sounds = sounds;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
