package entities;

public class Movies {
    private int id;
    private String title;
    private String description;

    public Movies() {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Movies(int movie_id, String movie_title, String movie_description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
