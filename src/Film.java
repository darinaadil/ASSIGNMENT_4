public class Film {
    private String title;
    private String director;
    private int duration;
    private int availableTickets;

    public Film(String title, String director, int duration, int availableTickets) {
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.availableTickets = availableTickets;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getDuration() {
        return duration;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void reduceTickets() {
        if (availableTickets > 0) {
            availableTickets--;
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Director: " + director + ", Duration: " + duration + " min, Available Tickets: " + availableTickets;
    }
}