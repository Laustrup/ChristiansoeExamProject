package group_g.christiansoeexamproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sound {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

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
