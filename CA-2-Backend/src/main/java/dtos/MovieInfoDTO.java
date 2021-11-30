package dtos;

import entities.MovieInfo;


public class MovieInfoDTO {

    private long id;
    private String comment;
    private String rating;
    private String title;
    private String username;

    public MovieInfoDTO (MovieInfo mi) {
        this.id = mi.getId();
        this.comment = mi.getComment();
        this.rating = mi.getRating();
        this.title = mi.getTitle();
        this.username = mi.getUsername();
    }

    public MovieInfoDTO(long id, String comment, String rating, String title, String username) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
        this.title = title;
        this.username = username;
    }

    public MovieInfoDTO () {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
