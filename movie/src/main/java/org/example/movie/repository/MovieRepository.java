package org.example.movie.repository;

import org.example.movie.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    private final JdbcTemplate jdbcTemplate;

    public MovieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Movie> movieRowMapper = (rs, rowNum) -> new Movie(
            rs.getLong("id"),
            rs.getString("title"),
            rs.getString("director"),
            rs.getInt("duration"),
            rs.getInt("available_tickets")
    );

    public List<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieRowMapper);
    }

    public Movie findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", movieRowMapper, id);
    }
}
