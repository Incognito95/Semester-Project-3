package facades;

import com.google.gson.Gson;
import dtos.MovieDTO;

import java.util.ArrayList;
import java.util.List;


public class MovieFacade {
    public static void main(String[] args) {


        Gson gson = new Gson();

    String jsonString = gson.toJson(Movie);
        List<String> List = new ArrayList<>();
        List<MovieDTO> MovieList = new ArrayList<>();
        List.add(jsonString);

        
    }
}
