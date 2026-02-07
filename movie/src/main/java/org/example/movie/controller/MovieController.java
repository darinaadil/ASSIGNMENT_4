package org.example.movie.controller;

import org.example.movie.model.Film;
import org.example.movie.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Film> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Film getMovieById(@PathVariable Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}
