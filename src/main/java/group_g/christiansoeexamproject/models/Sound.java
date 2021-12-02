package group_g.christiansoeexamproject.models;

import javax.persistence.Entity;

@Entity
public class Sound {

    private String filePath;

    public Sound (String filePath){
        this.filePath = filePath;
    }

    public Sound(){

    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
