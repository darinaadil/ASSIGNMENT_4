package org.example.movie.model;

public class Movie {
    private Long id;
    private String title;
    private String director;
    private int duration;
    private int availableTickets;

    public Movie() {}

    public Movie(Long id, String title, String director, int duration, int availableTickets) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.availableTickets = availableTickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }
}
