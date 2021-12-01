package entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "movie_id", length = 25)
    private Long id;
    @Column(name = "title", length = 25)
    private String title;
    @Column(name = "description", length = 25)
    private String description;

    @OneToMany(mappedBy = "movies", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<MovieInfo> movieInfo;

    public Movies() {
    }

    public Movies(Long id, String title, String description, List<MovieInfo> movieInfo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.movieInfo = new ArrayList<>();
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
}
