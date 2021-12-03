package facades;

import dtos.MovieCommentDTO;
import entities.MovieInfo;
import entities.Movies;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MovieFacade {
    private static EntityManagerFactory emf;
    private static MovieFacade instance;

    private MovieFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static MovieFacade getMovieFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    public boolean CreateComment(MovieCommentDTO mDTO) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, mDTO.getUsername());

        if (user != null) {
            Movies movies = em.find(Movies.class, mDTO.getMovieId());

        if (movies != null) {
                MovieInfo movieInfo = new MovieInfo(mDTO.getComment(), 5, movies, user);
                user.AddMovieInfo(movieInfo);
        }

        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();

       }

        return true;
    }

}
