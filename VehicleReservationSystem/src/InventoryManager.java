import enums.BookingStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class InventoryManager {
    List<Vehicle> vehicles;

    public InventoryManager(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void AddVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public void RemoveVehicle(Vehicle v){
        vehicles.remove(v);
    }

    public void UpdateStatus(Vehicle vehicle, BookingStatus status) {
        for(Vehicle v: vehicles) {
            if (v.GetId() == vehicle.GetId()) {
                v.SetStatus(status);
            }
        }
    }

    public List<Vehicle> GetAllVehicles() {
        return this.vehicles;
    }

    public List<Vehicle> GetFilteredVehicles(Filters filters) {
        List<Vehicle> filtered_vehicle = new ArrayList<Vehicle>();
        for(Vehicle v : this.vehicles) {
            if(filters.GetCC() > 0 && v.GetFilters().GetCC() == filters.GetCC()) {
                filtered_vehicle.add(v);
                if(!filters.GetColor().isEmpty()) {
                    if(!v.filters.GetColor().equals(filters.GetColor())){
                        filtered_vehicle.remove(v);
                    }
                }
            }
        }
        return filtered_vehicle;
    }

    public Reservation ReserveVehicle(Vehicle v, Date booking_date, Date release_date){
        String uniqueID = UUID.randomUUID().toString();
        return new Reservation(uniqueID,v,booking_date,release_date);
    }
}
