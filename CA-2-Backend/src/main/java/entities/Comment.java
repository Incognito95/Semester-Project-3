package entities;

public class Comment {
    private long movie_id;
    private String user_name;
    private String comment;

    public Comment() {
    }

    public Comment(long movie_id, String user_name, String comment) {
        this.movie_id = movie_id;
        this.user_name = user_name;
        this.comment = comment;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
