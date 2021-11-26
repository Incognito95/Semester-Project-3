package dtos;

import entities.Movies;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MovieDTO {
    private int id;
    private String title;
    private String description;

    public MovieDTO() {
    }

    List<MovieDTO> MovieList = new ArrayList<>();
    Movies movies = new Movies();

//     for (int i = 0; i < movies.length(); i++) {
//        MovieList.add(movie[i]);
//     }

    public MovieDTO(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MovieDTO{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }

//    public void addPerson(Person person) {
//        if (person != null) { // if person doesn't exist insert person into person table
//            this.persons.add(person); // add person to table
//            person.getHobbies().add(this); // add person into hobby table
//        }
//    }

}
