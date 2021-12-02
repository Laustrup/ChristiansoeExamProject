package group_g.christiansoeexamproject.models;

import java.util.List;

public abstract class Location {

    private String title;
    private String description;
    private List<Image> images;
    private String longitude;
    private String latitude;

    public Location(String title, String description, List<Image> images, String longitude, String latitude){
        this.title = title;
        this.description = description;
        this.images = images;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location(){

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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
