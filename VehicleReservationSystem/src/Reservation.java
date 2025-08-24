import java.util.Date;

public class Reservation {
    String id;
    Vehicle vehicle;
    Date booking_date;
    Date release_date;
    long cost;

    public Reservation(String id, Vehicle vehicle, Date booking, Date release) {
        this.id = id;
        this.vehicle = vehicle;
        this.booking_date = booking;
        this.release_date = release;
        this.cost = 0;
    }

    public void SetCost(long cost) {
        this.cost = cost;
    }

    public long GetCost(){
        return this.cost;
    }

    public Date GetBookingDate() {
        return this.booking_date;
    }

    public Date GetReleaseDate() {
        return this.release_date;
    }

    public Vehicle GetVehicle() {
        return this.vehicle;
    }

    public String GetId() {
        return this.id;
    }
}
