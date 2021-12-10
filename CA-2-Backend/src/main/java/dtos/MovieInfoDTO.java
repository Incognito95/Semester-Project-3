package dtos;

import entities.MovieInfo;


public class MovieInfoDTO {

    private long id;
    private String comment;
    private int rating;
    private String title;
    private String username;

    public MovieInfoDTO (MovieInfo mi) {
        this.id = mi.getId();
        this.comment = mi.getComment();
        this.rating = mi.getRating();
        this.username = mi.getUser().getUserName();

    }

    public MovieInfoDTO(long id, String comment, int rating) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
