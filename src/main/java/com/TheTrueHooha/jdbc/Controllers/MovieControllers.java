package com.TheTrueHooha.jdbc.Controllers;

import com.TheTrueHooha.jdbc.Entity.Movie;
import com.TheTrueHooha.jdbc.Service.MovieService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieControllers {

    private final MovieService movieService;

    public MovieControllers(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> listMovies() {
        return movieService.getMovies();
    }

    @GetMapping("{id}")
    public Movie getMovieById (@PathVariable("id")Integer id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    public void addNewMovie (@RequestBody Movie movie) {
        movieService.addNewMovie(movie);
    }

    @DeleteMapping("{id}")
    public void deleMovieById (@PathVariable ("id") Integer id) {
        movieService.deleMovie(id);
    }

    //todo: update movies
}
