import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String name;
    private List<Film> films;

    public Cinema(String name) {
        this.name = name;
        this.films = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public List<Film> getFilms() {
        return films;
    }

    @Override
    public String toString() {
        return "Cinema: " + name;
    }
}