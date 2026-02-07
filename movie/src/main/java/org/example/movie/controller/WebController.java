package org.example.movie.controller;

import org.example.movie.model.Viewer;
import org.example.movie.repository.CinemaRepository;
import org.example.movie.repository.MovieRepository;
import org.example.movie.repository.ViewerRepository;
import org.example.movie.repository.BookingRepository;
import org.example.movie.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;
    private final ViewerRepository viewerRepository;
    private final BookingRepository bookingRepository;
    private final BookingService bookingService;

    // Внедряем все зависимости
    public WebController(CinemaRepository cinemaRepository,
                         MovieRepository movieRepository,
                         ViewerRepository viewerRepository,
                         BookingRepository bookingRepository,
                         BookingService bookingService) {
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
        this.viewerRepository = viewerRepository;
        this.bookingRepository = bookingRepository;
        this.bookingService = bookingService;
    }

    // 1. Главная страница с формой бронирования
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cinemas", cinemaRepository.findAll());
        model.addAttribute("films", movieRepository.findAll()); // Используем "films", как в HTML
        model.addAttribute("viewers", viewerRepository.findAll());
        return "index"; // файл src/main/resources/templates/index.html
    }

    // 2. Обработка формы бронирования (POST запрос)
    @PostMapping("/web/book")
    public String makeBooking(@RequestParam String viewerName,
                              @RequestParam Long filmId,
                              @RequestParam String seat) {
        try {
            Viewer viewer = viewerRepository.findByName(viewerName)
                    .orElseGet(() -> viewerRepository.save(new Viewer(viewerName)));

            bookingService.createBooking(viewer.getId(), filmId, seat);

            return "redirect:/web/bookings";
        } catch (Exception e) {
            // ЭТО ВАЖНО: ошибка появится внизу в IDEA (вкладка Run)
            e.printStackTrace();
            return "redirect:/?error=" + e.getMessage();
        }
    }

    @GetMapping("/web/bookings")
    public String viewBookings(Model model) {
        model.addAttribute("bookings", bookingRepository.findAll());
        return "booking-list"; // Проверь, что файл называется именно так!
    }

    @PostMapping("/web/bookings/delete")
    public String deleteBooking(@RequestParam Long id) {
        try {
            bookingService.deleteBooking(id);
            return "redirect:/web/bookings"; // Возвращаемся на список после удаления
        } catch (Exception e) {
            return "redirect:/web/bookings?error=" + e.getMessage();
        }
    }
}