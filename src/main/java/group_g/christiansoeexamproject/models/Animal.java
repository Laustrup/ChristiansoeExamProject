package group_g.christiansoeexamproject.models;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
    private String report;


    @OneToMany(mappedBy = "animal")
    @JsonBackReference
    private List<Image> images;

    @OneToMany(mappedBy = "animal")
    @JsonBackReference
    private List<Sound> sounds;




    public Animal(String title, String report, List<Image> images, List<Sound> sounds){
        this.title = title;
        this.report = report;
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

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
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
