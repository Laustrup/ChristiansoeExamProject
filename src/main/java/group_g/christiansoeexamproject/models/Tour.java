package group_g.christiansoeexamproject.models;

import java.util.List;

public class Tour {

    private String title;
    private String description;
    private List<Location> locations;

    public Tour (String title, String description, List<Location> locations){
        this.title = title;
        this.description = description;
        this.locations = locations;
    }

    public Tour(){

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
