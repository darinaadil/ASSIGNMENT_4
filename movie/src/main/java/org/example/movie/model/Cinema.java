package org.example.movie.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cinemas")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private List<Film> films;

    public Cinema() {
        this.films = new ArrayList<>();
    }

    public Cinema(String name) {
        this.name = name;
        this.films = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFilm(Film film) {
        films.add(film);
        film.setCinema(this);
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Cinema: " + name;
    }
}