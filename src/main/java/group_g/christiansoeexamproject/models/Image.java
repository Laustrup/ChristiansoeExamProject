package group_g.christiansoeexamproject.models;

import javax.persistence.*;

@Entity
@Table(name="image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String filePath;


    public Image (String filePath){
        this.filePath = filePath;
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
}
