package com.TheTrueHooha.jdbc.Dao;

import com.TheTrueHooha.jdbc.Entity.Movie;
import java.util.List;
import java.util.Optional;

public interface MovieDao {
    List<Movie> selectMovies();
    int addMovie (Movie movie);
    int deleteMovie (int id);
    Optional<Movie> selectMovieById (int id);
    //TODO: add option to edit movie
}
