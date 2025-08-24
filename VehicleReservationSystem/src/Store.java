import enums.BookingStatus;
import enums.PaymentMode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static utils.util.GetBookingStatusString;

public class Store {
    InventoryManager inventory_manager;
    ComputeCost compute_cost;
    List<Reservation> reservations;
    Location location;

    public Store(InventoryManager manager, Location loc){
        this.inventory_manager = manager;
        this.compute_cost = new ComputeCost();
        this.reservations = new ArrayList<Reservation>();
        this.location = loc;
    }

    public void ListAllVehicles() {
        List<Vehicle> vehicles = inventory_manager.GetAllVehicles();
        for(Vehicle v: vehicles){
            System.out.printf("Car %s of color %s and cc %d with status as %s%n",
                    v.GetName(), v.GetColor(), v.GetCC(), GetBookingStatusString(v.GetCurrentBookingStatus()));
        }
    }

    public List<Vehicle> ListAndGetFilteredVehicles(Filters filters){
        List<Vehicle> vehicles = inventory_manager.GetFilteredVehicles(filters);
        for(Vehicle v: vehicles){
            System.out.printf("Car %s is %s%n", v.GetName(),GetBookingStatusString(v.GetCurrentBookingStatus()));
        }
        return vehicles;
    }

    public void BookVehicle(PaymentMode mode, Vehicle v, Date booking_date, Date release_date){
        Reservation reservation = inventory_manager.ReserveVehicle(v, booking_date, release_date);
        inventory_manager.UpdateStatus(v, BookingStatus.Processing);
        long cost = compute_cost.GetPrice(reservation);
        reservation.SetCost(cost);
        System.out.printf("Total cost of booking vehicle is: %d, Pay to book%n", cost);
        if (mode == PaymentMode.Cash) {
            System.out.printf("Paid amount through cash%n");
        } else if (mode == PaymentMode.UPI){
            System.out.printf("Paid amount through UPI%n");
        } else {
            System.out.printf("Paid amount through Credit card%n");
        }
        this.reservations.add(reservation);
        inventory_manager.UpdateStatus(reservation.GetVehicle(), BookingStatus.Booked);
    }

    public void ReleaseVehicle(String reservation_id){
        Reservation r = null;
        for(Reservation res : reservations){
            if(Objects.equals(res.GetId(), reservation_id)){
                r = res;
                this.reservations.remove(res);
                break;
            }
        }
        if (r != null) {
            this.inventory_manager.UpdateStatus(r.GetVehicle(), BookingStatus.Released);
            System.out.printf("Vehicle %s released", r.GetVehicle().GetName());
        }
    }

    public Location GetLocation() {
        return this.location;
    }
}
