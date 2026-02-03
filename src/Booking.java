import java.time.LocalDateTime;

public class Booking {
    private Viewer viewer;
    private Film film;
    private LocalDateTime bookingTime;

    public Booking(Viewer viewer, Film film) {
        this.viewer = viewer;
        this.film = film;
        this.bookingTime = LocalDateTime.now();

        if (film.getAvailableTickets() > 0) {
            film.reduceTickets();
        } else {
            throw new IllegalStateException("No tickets available for this movie!");
        }
    }

    public Viewer getViewer() {
        return viewer;
    }

    public Film getFilm() {
        return film;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    @Override
    public String toString() {
        return "Booking for: " + viewer.getName() + " | Film: " + film.getTitle() + " | Time: " + bookingTime;
    }
}