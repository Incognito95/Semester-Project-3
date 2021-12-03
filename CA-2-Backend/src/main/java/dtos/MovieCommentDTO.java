package dtos;

public class MovieCommentDTO {
    private long movieId;
    private String comment;
    private String username;

    public MovieCommentDTO(String comment, String username, long movieId) {
        this.comment = comment;
        this.username = username;
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

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }
}
