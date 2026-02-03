import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Cinema> cinemas = new ArrayList<>();
    private List<Viewer> viewers = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public Menu() {
        Cinema cinema1 = new Cinema("Cineplex");
        cinema1.addFilm(new Film("Inception", "Christopher Nolan", 148, 10));
        cinema1.addFilm(new Film("The Matrix", "Wachowski Brothers", 136, 5));

        Cinema cinema2 = new Cinema("MovieLand");
        cinema2.addFilm(new Film("Interstellar", "Christopher Nolan", 169, 3));
        cinema2.addFilm(new Film("The Dark Knight", "Christopher Nolan", 152, 8));

        cinemas.add(cinema1);
        cinemas.add(cinema2);
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Movie Ticket Reservation System ---");
            System.out.println("1. View Cinemas");
            System.out.println("2. Make a Booking");
            System.out.println("3. View All Bookings");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCinemas();
                    break;
                case 2:
                    makeBooking();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public void viewCinemas() {
        System.out.println("\n--- Available Cinemas ---");
        for (int i = 0; i < cinemas.size(); i++) {
            System.out.println((i + 1) + ". " + cinemas.get(i));
        }
    }

    public void makeBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        Viewer viewer = new Viewer(name, age, email);

        viewCinemas();
        System.out.print("Select the cinema to view movies (1-" + cinemas.size() + "): ");
        int cinemaChoice = scanner.nextInt();

        if (cinemaChoice < 1 || cinemaChoice > cinemas.size()) {
            System.out.println("Invalid cinema choice!");
            return;
        }

        Cinema selectedCinema = cinemas.get(cinemaChoice - 1);
        viewFilms(selectedCinema);

        System.out.print("Select the movie to book (1-" + selectedCinema.getFilms().size() + "): ");
        int filmChoice = scanner.nextInt();

        if (filmChoice < 1 || filmChoice > selectedCinema.getFilms().size()) {
            System.out.println("Invalid movie choice!");
            return;
        }

        Film film = selectedCinema.getFilms().get(filmChoice - 1);

        // Попытка забронировать билет
        try {
            Booking booking = new Booking(viewer, film);
            bookings.add(booking);
            System.out.println("Booking successful!");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewFilms(Cinema cinema) {
        System.out.println("\n--- Films in " + cinema.getName() + " ---");
        for (int i = 0; i < cinema.getFilms().size(); i++) {
            System.out.println((i + 1) + ". " + cinema.getFilms().get(i));
        }
    }

    public void viewBookings() {
        System.out.println("\n--- All Bookings ---");
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }
}