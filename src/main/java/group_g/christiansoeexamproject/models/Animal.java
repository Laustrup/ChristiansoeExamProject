package group_g.christiansoeexamproject.models;

import java.util.List;

public class Animal {

    private String title;
    private String description;
    private List<Image> images;
    private List<Sound> sounds;

    public Animal(String title, String description, List<Image> images, List<Sound> sounds){
        this.title = title;
        this.description = description;
        this.images = images;
        this.sounds = sounds;
    }

    public Animal(){

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
