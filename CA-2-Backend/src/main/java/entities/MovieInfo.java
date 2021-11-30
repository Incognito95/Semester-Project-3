package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "movieinfo")
public class MovieInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id", length = 25)
    private long id;
    @Column(name = "username", length = 25)
    private String username;
    @Column(name = "comment", length = 25)
    private String comment;
    @Column(name = "rating", length = 25)
    private String rating;
    @Column(name = "title", length = 25)
    private String title;

    @ManyToOne
    private Movies movies;

    @ManyToOne
    private User user;

    public MovieInfo() {
    }

    public MovieInfo(long id, String username, String comment, String rating, String title, List<Movies> moviesList) {
        this.id = id;
        this.username = username;
        this.comment = comment;
        this.rating = rating;
        this.title = title;
        this.movies = movies;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
