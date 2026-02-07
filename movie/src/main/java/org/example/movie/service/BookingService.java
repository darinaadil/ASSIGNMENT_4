package org.example.movie.service;

// ИСПОЛЬЗУЕМ ТОЛЬКО SPRING ИМПОРТЫ
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.movie.model.Booking;
import org.example.movie.repository.BookingRepository;
import org.example.movie.repository.MovieRepository;
import org.example.movie.repository.ViewerRepository;

@Service // Правильная аннотация
public class BookingService {
    private final BookingRepository bookingRepository;
    private final MovieRepository movieRepository;
    private final ViewerRepository viewerRepository;

    public BookingService(BookingRepository bookingRepository,
                          MovieRepository movieRepository,
                          ViewerRepository viewerRepository) {
        this.bookingRepository = bookingRepository;
        this.movieRepository = movieRepository;
        this.viewerRepository = viewerRepository;
    }

    @Transactional
    public Booking createBooking(Long viewerId, Long filmId, String seat) {
        var viewer = viewerRepository.findById(viewerId)
                .orElseThrow(() -> new RuntimeException("Зритель не найден"));

        var film = movieRepository.findById(filmId)
                .orElseThrow(() -> new RuntimeException("Фильм не найден"));

        if (bookingRepository.existsByFilmIdAndSeat(filmId, seat)) {
            throw new RuntimeException("Это место уже забронировано!");
        }

        if (film.getAvailableTickets() <= 0) {
            throw new RuntimeException("Билетов больше нет!");
        }

        Booking booking = new Booking();
        booking.setViewer(viewer);
        booking.setFilm(film);
        booking.setSeat(seat);

        film.reduceTickets();
        movieRepository.save(film);

        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Бронирование не найдено");
        }
        bookingRepository.deleteById(id);
    }
}