import java.time.LocalDateTime;

public class Booking {
    Movie movie;
    LocalDateTime movie_time;
    BookingStatus status;
    Seat[] seats;
    int screen_id;

    public Booking(Movie movie, Seat[] seats, LocalDateTime movie_time, int screen_id){
        this.movie = movie;
        this.seats = seats;
        this.status = BookingStatus.PENDING;
        this.movie_time = movie_time;
        this.screen_id = screen_id;
    }

    public void completeBooking() {
        this.status = BookingStatus.BOOKED;
        for(Seat seat: this.seats) {
            seat.changeOccupyStatus(true);
        }
        System.out.printf("Booking confirmed for Movie: %s%n", movie.getName());
        // print seat information too.
    }
}
