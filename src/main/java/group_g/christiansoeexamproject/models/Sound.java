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
}
