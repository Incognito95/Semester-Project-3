package rest;

import entities.Movies;
import entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class DemoResource {

    List<Movies> movies = new ArrayList<>();
    List<User> users = new ArrayList<>();

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
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

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("user")
//    @RolesAllowed("user")
//    public String getFromUser() {
//        String thisuser = securityContext.getUserPrincipal().getName();
//        return "{\"msg\": \"Hello to User: " + thisuser + "\"}";
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }
    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("chucknorris")
//    public String chuckNorris() {
//        // https://api.chucknorris.io/jokes/random
//        return "{\"msg\": \"chuck norris jokes: " + "\"}";
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("dadjokes")
//    public String dadJokes() {
//        return "{\"msg\": \"Dad jokes: " + "\"}";
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public String login() {
        return "{\"msg\": \"this is our login page: " + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("movies")
    public List<Movies> ShowAllMovies() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("SELECT movie_id, movie_title, movie_description, movie_images FROM movies");
        while (rs.next()) {
            Movies movie = new Movies();
            movie.setId(rs.getInt("movie_id"));
            movie.setTitle(rs.getString("movie_title"));
            movie.setDescription(rs.getString("movie_description"));
            movie.setImages(rs.getString("movie_images"));
            movies.add(movie);
        }
        return movies;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("moviepage")
    public List<Movies> MoviePage() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("SELECT movie_id, movie_title, movie_description, movie_images FROM movies WHERE movie_id = movie_id");
        if (rs.next()) {
            Movies movie = new Movies();
            movie.setId(rs.getInt("movie_id"));
            movie.setTitle(rs.getString("movie_title"));
            movie.setDescription(rs.getString("movie_description"));
            movie.setImages(rs.getString("movie_images"));
            movies.add(movie);
        }
        return movies;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    public List<User> ShowUserByLoggedIn() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("SELECT user_name, FROM users");
        while (rs.next()) {
            User user = new User();
            user.setUserName(rs.getString("user_name"));
            users.add(user);
        }
        return users;
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
    public void main(String[] args) throws SQLException {
        ShowUserByLoggedIn(); // show user based on logged in user
        ShowAllMovies(); // show all movies
//        MoviePage(); // show one movie


    }



}