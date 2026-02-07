package org.example.movie.controller;

import org.example.movie.model.Cinema;
import org.example.movie.repository.CinemaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {
    private final CinemaRepository cinemaRepository;

    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cinema> getCinemaById(@PathVariable Long id) {
        return cinemaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cinema createCinema(@RequestBody Cinema cinema) {
        return cinemaRepository.save(cinema);
    }
}
