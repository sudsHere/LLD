import enums.BookingStatus;
import enums.VehicleType;

import java.time.LocalDate;

public class Vehicle {
    int id;
    String name;
    VehicleType type;
    String vehicle_number;
    BookingStatus curr_status;
    int cc;
    String color;
    LocalDate manufacturing_date;
    Filters filters;

    public Vehicle(int id, String name, VehicleType vehicle_type, String vehicle_number, int cc, String color, LocalDate manuf_date) {
        this.id = id;
        this.name = name;
        this.vehicle_number = vehicle_number;
        this.type = vehicle_type;
        this.cc = cc;
        this.color = color;
        this.manufacturing_date = manuf_date;
        this.curr_status = BookingStatus.Available;
        this.filters = new Filters(color, cc);
    }

    public int GetCC() {
        return this.cc;
    }

    public String GetName() {
        return this.name;
    }

    public String GetColor() {
        return this.color;
    }

    public int GetId() {
        return this.id;
    }

    public void SetStatus(BookingStatus status) {
        this.curr_status = status;
    }

    public Filters GetFilters() {
        return  this.filters;
    }

    public BookingStatus GetCurrentBookingStatus() {
        return this.curr_status;
    }
}
