package org.example.movie.repository;

import org.example.movie.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsByFilmIdAndSeat(Long filmId, String seat);
}
