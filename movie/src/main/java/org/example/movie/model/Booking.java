package org.example.movie.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "viewer_id")
    private Viewer viewer;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @Column(name = "seat")
    private String seat;

    @Column(name = "booking_time")
    private LocalDateTime bookingTime;


    // 1. Пустой конструктор (нужен для JPA)
    public Booking() {
        this.bookingTime = LocalDateTime.now();
    }

    // 2. Полный конструктор для использования в сервисе
    public Booking(Viewer viewer, Film film, String seat) {
        this.viewer = viewer;
        this.film = film;
        this.seat = seat;
        this.bookingTime = LocalDateTime.now();
    }

    public String getSeat() { return seat; }
    public void setSeat(String seat) { this.seat = seat; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", viewer=" + (viewer != null ? viewer.getName() : "null") +
                ", film=" + (film != null ? film.getTitle() : "null") +
                ", bookingTime=" + bookingTime +
                '}';
    }
}