package com.TheTrueHooha.jdbc.Service;

import com.TheTrueHooha.jdbc.Dao.MovieDao;
import com.TheTrueHooha.jdbc.Entity.Movie;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class MovieDataAccessService implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public MovieDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> selectMovies() {
        var sql = """
                SELECT id, name, studio, producer, release_date
                FROM movie
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public int addMovie(Movie movie) {
        var sql = """
                INSERT INTO movie(name, release_date, producer, studio)
                VALUES (?, ?)
                """;
        return jdbcTemplate.update(
                sql,
                movie.name(),
                movie.producer(),
                movie.studio(),
                movie.releaseDate()
        );
    }

    @Override
    public int deleteMovie(int id) {
        var sql = """
                DELETE FROM movie
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        var sql = """
                SELECT id,
                name,
                studio,
                producer,
                release_date
                FROM movie
                WHERE id = ?
                """;
        return jdbcTemplate.query(sql, new MovieRowMapper(), id)
                .stream()
                .findFirst();
    }
}
