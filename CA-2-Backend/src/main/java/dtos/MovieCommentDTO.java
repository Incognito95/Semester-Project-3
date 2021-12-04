package dtos;

public class MovieCommentDTO {
    private long movieId;
    private String comment;
    private String username;
    private int rating;

    public MovieCommentDTO(String comment, String username, long movieId, int rating) {
        this.comment = comment;
        this.username = username;
        this.movieId = movieId;
        this.rating = rating;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
