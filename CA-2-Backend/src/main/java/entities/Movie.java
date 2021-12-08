package entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "movie_id", length = 25)
    private Long id;
    @Column(name = "title", length = 1000)
    private String title;
    @Column(name = "description", length = 2500)
    private String description;

    @Column(name = "images", length = 1000)
    private String images;

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<MovieInfo> movieInfo;

    public Movie() {
    }

    public Movie(Long id, String title, String description, String images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.images = images;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public List<MovieInfo> getMovieInfo() {
        return movieInfo;
    }

    public void addMovieInfo(MovieInfo movieInfo) {
        this.movieInfo.add(movieInfo);
    }

}
