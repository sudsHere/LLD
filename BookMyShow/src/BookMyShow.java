import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookMyShow {
    TheatreController theatre_controller;
    MovieController movie_controller;
    ArrayList<Theatre> valid_theatres;

    public BookMyShow() {
        this.theatre_controller = new TheatreController();
        this.movie_controller = new MovieController();
        valid_theatres = new ArrayList<>();

        AddMovies();
        AddTheatres();

        // get movies for city hyd
        this.getMovies("Hyderabad");

        // get all the shows for BAHUBALI
        Movie movie = this.movie_controller.getMovie("Hyderabad", "Bahubali");
        this.getAllTheatresFor(movie, "Hyderabad");

        // book a movie
        int[] interested_seats = {5,6,7};
        Show show = this.valid_theatres.get(1).getShows().get(1);
        Booking booking = show.makeBooking(interested_seats);
        // Make payment
        // confirm booking
        booking.completeBooking();
    }

    void AddMovies() {
        Movie movie_1 = new Movie(1, "Bahubali", 120);
        Movie movie_2 = new Movie(1, "Avengers", 160);

        this.movie_controller.AddMovieForCity("Hyderabad", movie_1);
        this.movie_controller.AddMovieForCity("Delhi", movie_2);
        this.movie_controller.AddMovieForCity("Hyderabad", movie_2);
    }

    void AddTheatres(){
        Movie movie_1 = new Movie(1, "Bahubali", 120);
        Movie movie_2 = new Movie(1, "Avengers", 160);
        Theatre theatre_1 = new Theatre("PVR", "Hyderabad");
        LocalDateTime time = LocalDateTime.now();
        theatre_1.addShows(new Show(movie_1, time, new Screen(1, 50)));
        theatre_1.addShows(new Show(movie_2, time, new Screen(2, 50)));
        Theatre theatre_2 = new Theatre("Prasads", "Hyderabad");
        theatre_2.addShows(new Show(movie_1, time, new Screen(1, 100)));
        theatre_2.addShows(new Show(movie_2, time, new Screen(2, 50)));
        Theatre theatre_3 = new Theatre("PVR", "Delhi");
        theatre_3.addShows(new Show(movie_1, time, new Screen(1, 80)));
        theatre_3.addShows(new Show(movie_2, time, new Screen(2, 50)));
        Theatre theatre_4 = new Theatre("INOX", "Delhi");
        theatre_4.addShows(new Show(movie_1, time, new Screen(1, 50)));
        theatre_4.addShows(new Show(movie_2, time, new Screen(2, 90)));
        this.theatre_controller.addTheatre("Hyderabad", theatre_2);
        this.theatre_controller.addTheatre("Hyderabad", theatre_1);
        this.theatre_controller.addTheatre("Delhi", theatre_3);
        this.theatre_controller.addTheatre("Delhi", theatre_4);
    }

    void getMovies(String city) {
        this.movie_controller.getMoviesForACity(city);
    }

    void getAllTheatresFor(Movie movie, String city) {
        this.valid_theatres = this.theatre_controller.getAllTheatreWithShowsFor(movie,city);
    }

    void bookMovie(Show show, int[] interested_seats) {
        show.makeBooking(interested_seats);
    }
}
