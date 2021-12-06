package entities;

import javax.persistence.*;
import java.io.Serializable;
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
    private Movie movie;

    @ManyToOne
    private User user;

    public MovieInfo() {
    }

    public MovieInfo(String comment, int rating, Movie movie, User user) {
        this.comment = comment;
        this.rating = rating;
        this.movie = movie;
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


    public Movie getMovies() {
        return movie;
    }

    public void setMovies(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
