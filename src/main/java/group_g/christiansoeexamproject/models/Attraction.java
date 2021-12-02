package group_g.christiansoeexamproject.models;

import java.util.List;

public class Attraction extends Location {

    private List<Animal> animals;
    private List<Sound> sounds;

    public Attraction (List<Animal> animals, List<Sound> sounds){
        this.animals = animals;
        this.sounds = sounds;
    }

    public Attraction(){

    }


    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Sound> getSounds() {
        return sounds;
    }

    public void setSounds(List<Sound> sounds) {
        this.sounds = sounds;
    }
}
