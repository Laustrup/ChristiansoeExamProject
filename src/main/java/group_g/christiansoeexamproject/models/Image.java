package group_g.christiansoeexamproject.models;

public class Image {

    private String filePath;

    public Image (String filePath){
        this.filePath = filePath;
    }

    public Image(){

    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
