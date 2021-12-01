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
    @Column(name = "movieInfo_id", length = 10)
    private long id;
    @Column(name = "comment", length = 100)
    private String comment;
    @Column(name = "rating", length = 25)
    private int rating;


    @ManyToOne
    private Movies movies;

    @ManyToOne
    private User user;

    public MovieInfo() {
    }

    public MovieInfo(String comment, int rating, Movies movies, User user) {
        this.comment = comment;
        this.rating = rating;
        this.movies = movies;
        this.user = user;
    }

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
