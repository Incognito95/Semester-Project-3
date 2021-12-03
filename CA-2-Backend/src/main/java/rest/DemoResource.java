package rest;

import com.google.gson.Gson;
import dtos.MovieCommentDTO;
import dtos.MovieDTO;
import entities.MovieInfo;
import entities.Movies;
import entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.PathParam;

import facades.MovieFacade;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class DemoResource {

    List<Movies> movies = new ArrayList<>();
    List<Movies> info = new ArrayList<>();
    List<User> users = new ArrayList<>();
    List<MovieInfo> comment = new ArrayList<>();
    List<MovieInfo> ratings = new ArrayList<>();
    List<MovieInfo> comments = new ArrayList<>();

    Gson gson = new Gson();

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    public static final MovieFacade MOVIE_FACADE = MovieFacade.getMovieFacade(EMF);

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    //Just to verify if the database is setup
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery ("select u from User u",entities.User.class);
            List<User> users = query.getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public String login() {
        return "{\"msg\": \"this is our login page: " + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    public List<User> GetInfoFromUser() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        TypedQuery <User> query = em.createQuery("SELECT u from User u where u.userName=:username", entities.User.class);
        List<User> result = query.getResultList();
        return result;
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("AddMovieComment")
    public void AddMovieComment(String jsonString) throws SQLException {
        System.out.println(jsonString);
        MovieCommentDTO mDTO = gson.fromJson(jsonString, MovieCommentDTO.class);
        System.out.println(mDTO.getUsername() + mDTO.getComment() + mDTO.getMovieId());
        MOVIE_FACADE.CreateComment(mDTO);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("rating")
    public List<Movies> AddMovieRating() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("INSERT INTO movie_info SET comment = ?"); //Mangler
        while (rs.next()) {
            Movies movie = new Movies();
            movie.setId(rs.getLong("movie_id"));
            movie.setTitle(rs.getString("title"));
            movies.add(movie);
        }
        return movies;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("DisplayMovieRatings")
    public List<MovieInfo> DisplayMovieRatings() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        TypedQuery <MovieInfo> query = em.createQuery("SELECT m from MovieInfo m where m.rating=m.rating", entities.MovieInfo.class);
        List<MovieInfo> result = query.getResultList();
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("DisplayMovieComments")
    public List<Movies> DisplayMovieComments() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        TypedQuery <Movies> query = em.createQuery("SELECT m FROM MovieInfo m WHERE m.comment = m.comment", entities.Movies.class);
        List<Movies> result = query.getResultList();
        return result;
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("movies")
    public List<Movies> ShowAllMovies() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        TypedQuery <Movies> query = em.createQuery("SELECT m from Movies m", entities.Movies.class);
        List<Movies> result = query.getResultList();
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("moviepage/{id}")
    public String MoviePage(@PathParam("id") long id) throws SQLException {
        MovieDTO movieDTO = MOVIE_FACADE.getMoviesById(id);
        return gson.toJson(movieDTO, MovieDTO.class);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("search")
    public void SearchForMovie(String jsonString) throws SQLException {
        System.out.println(jsonString);
        MovieDTO mDTO = gson.fromJson(jsonString, MovieDTO.class);
        System.out.println(mDTO.getTitle());
        MOVIE_FACADE.getMovieByTitle(mDTO);
    }


    // database connection
    public Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/semester-project?serverTimezone=UTC", "dev", "ax2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    // running methods
    public void main(String[] args) throws Exception {
//        ShowUserByLoggedIn(); // show user based on login
        ShowAllMovies(); // show all movies
        MoviePage(1); // show one movie
        GetInfoFromUser(); // show user
        AddMovieComment("hej"); // add comment to movie
        DisplayMovieComments(); // display comments for a movie
        AddMovieRating(); // display ratings for a movie
        DisplayMovieRatings(); // display ratings for a movie
        SearchForMovie("hej");

    }



}