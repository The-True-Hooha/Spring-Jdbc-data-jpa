package com.TheTrueHooha.jdbc.Service;

import com.TheTrueHooha.jdbc.Dao.MovieDao;
import com.TheTrueHooha.jdbc.Entity.Movie;
import com.TheTrueHooha.jdbc.Exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieDao movieDao;

    //adds a constructor parameter
    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public List<Movie> getMovies () {
        return movieDao.selectMovies();
    }

    public void addNewMovie(Movie movie) {
        //TODO: check if movie exits first before add the movie
        int result = movieDao.addMovie(movie);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong, try again");
        }
    }

    public void deleMovie(Integer id) {
        Optional<Movie> movie = movieDao.selectMovieById(id);
        movie.ifPresentOrElse(movie1 -> {
            int result = movieDao.deleteMovie(id);
            if (result != 1) {
                throw new IllegalStateException("sorry, cannot delete movie");
            }
        }, () -> {
            throw new NotFoundException(String.format("sorry, cannot find movie with id %s", id));
        });
    }

    public Movie getMovie(int id) {
        return movieDao.selectMovieById(id).orElseThrow(() -> new NotFoundException
                (String.format("sorry, cannot find movie with id %s", id)));
    }
}
