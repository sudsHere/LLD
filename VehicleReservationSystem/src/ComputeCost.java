import java.util.Date;

public class ComputeCost {
    int base_price = 100;
    int per_day_charge = 200;

    public long GetPrice(Reservation reservation){
        Date release_date = reservation.GetReleaseDate();
        Date booking_date = reservation.GetBookingDate();

        long diff_millis = release_date.getTime() - booking_date.getTime();
        long total_days = diff_millis / (1000 * 60 * 60 * 24); // convert ms → days

        long total_price = base_price + per_day_charge*total_days;
        System.out.println("Total days vehicle was booked for: " + total_days);
        System.out.println("Total price: " + total_price);

        return total_price;
    }
}
