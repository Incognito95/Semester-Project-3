package dtos;

import entities.Movie;
import entities.MovieInfo;

import java.util.ArrayList;
import java.util.List;

public class MovieDTO {

    private long id;
    private String description;
    private String title;
    private String images;
    private List<MovieInfoDTO> movieInfo = new ArrayList<>();

    public MovieDTO (Movie M) {
        this.id =  M.getId();
        this.description = M.getDescription();
        this.title = M.getTitle();
        this.images = M.getImages();
        M.getMovieInfo().forEach(m -> movieInfo.add(new MovieInfoDTO(m)));
    }

    public MovieDTO(long id, String description, String title, String images) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
