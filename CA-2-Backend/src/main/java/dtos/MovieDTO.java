package dtos;

import entities.Movies;

public class MovieDTO {

    private long id;
    private String description;
    private String title;

    public MovieDTO (Movies M) {
        this.id =  M.getId();
        this.description = M.getDescription();
        this.title = M.getTitle();

    }

    public MovieDTO (String description, String title) {
        this.description = description;
        this.title = title;
    }

    public MovieDTO () {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
