import java.time.LocalDateTime;
import java.util.ArrayList;

public class Show {
    Movie movie;
    LocalDateTime local_time;
    Screen screen;

    public Show(Movie movie, LocalDateTime time, Screen screen) {
        this.movie = movie;
        this.local_time = time;
        this.screen = screen;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public Screen getScreen() {
        return this.screen;
    }

    public LocalDateTime getLocalTime() {
        return this.local_time;
    }

    public Booking makeBooking(int[] interested_seats) {
        Seat[] seats = this.screen.getSeats();
        Seat[] seats_to_be_booked = new Seat[interested_seats.length];
        int i=0;
        for(int seat : interested_seats) {
            Seat s = seats[seat];
            if(s.isSeatOccupied()){
                System.out.printf("Seat is already booked, please try again");
                return null;
            }
            seats_to_be_booked[i] = s;
            i++;
        }
        return new Booking(this.movie, seats_to_be_booked, this.local_time, this.screen.getScreenId());
    }
}
