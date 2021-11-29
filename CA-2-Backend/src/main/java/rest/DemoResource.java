package rest;

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
import javax.ws.rs.POST;
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
    List<Movies> info = new ArrayList<Movies>();
    List<User> users = new ArrayList<>();
    List<MovieInfo> comment = new ArrayList<>();
    List<MovieInfo> ratings = new ArrayList<>();
    List<MovieInfo> comments = new ArrayList<>();

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
        ResultSet rs = getConnection().createStatement().executeQuery("SELECT user_name FROM users");
        while (rs.next()) {
            User user = new User();
            user.setUserName(rs.getString("user_name"));
            users.add(user);
        }
        return users;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("AddMovieComment")
    public List<MovieInfo> AddMovieComment() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("INSERT INTO movie_info SET comment = ?");
        while (rs.next()) {
            MovieInfo movieinfo = new MovieInfo();
            movieinfo.setComment(rs.getString("comment"));
            comment.add(movieinfo);
        }
        return comment;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("rating")
    public List<Movies> AddMovieRating() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("INSERT INTO movie_info SET comment = ?");
        while (rs.next()) {
            Movies movie = new Movies();
            movie.setId(rs.getInt("movie_id"));
            movie.setTitle(rs.getString("title"));
            movies.add(movie);
        }
        return movies;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("DisplayMovieRatings")
    public List<MovieInfo> DisplayMovieRatings() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("SELECT rating FROM movie_info");
        while (rs.next()) {
            MovieInfo rating = new MovieInfo();
            rating.setRating(rs.getString("rating"));
            ratings.add(rating);
        }
        return ratings;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("DisplayMovieComments")
    public List<MovieInfo> DisplayMovieComments() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("SELECT fk_user_name, comment FROM movie_info");
        while (rs.next()) {
            MovieInfo comment = new MovieInfo();
            comment.setUsername(rs.getString("fk_user_name"));
            comment.setComment(rs.getString("comment"));
            comments.add(comment);
        }
        return comments;
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("movies")
    public List<Movies> ShowAllMovies() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("SELECT movie_id, title FROM movies");
        while (rs.next()) {
            Movies movie = new Movies();
            movie.setId(rs.getInt("movie_id"));
            movie.setTitle(rs.getString("title"));
            movies.add(movie);
        }
        return movies;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("moviepage")
    public List<Movies> MoviePage() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("SELECT title, description FROM movies WHERE movie_id = movie_id");
        if (rs.next()) {
            Movies movieinfo = new Movies();
            movieinfo.setTitle(rs.getString("title"));
            movieinfo.setDescription(rs.getString("description"));
            info.add(movieinfo);
        }
        return info;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search")
    public List<Movies> SearchForMovie() throws SQLException {
        ResultSet rs = getConnection().createStatement().executeQuery("SELECT * FROM movies WHERE title LIKE '%far til fire %' AND title LIKE '%toy story%'");
        while (rs.next()) {
            Movies movieinfo = new Movies();
            movieinfo.setTitle(rs.getString("title"));
            info.add(movieinfo);
        }
        return info;
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
        MoviePage(); // show one movie
        GetInfoFromUser(); // show user
        AddMovieComment(); // add comment to movie
        DisplayMovieComments(); // display comments for a movie
        AddMovieRating(); // display ratings for a movie
        DisplayMovieRatings(); // display ratings for a movie
        SearchForMovie();

    }



}