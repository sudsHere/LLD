package ParkingLot.ParkingSpace;

import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Types.VehicleType;

public abstract class ParkingSpace {
    int id;
    Vehicle vehicle;
    VehicleType vehicle_type;
    int price;
    boolean is_empty;

    public ParkingSpace(int Id, int price) {
        this.id = Id;
        this.vehicle = null;
        this.vehicle_type = null;
        this.is_empty = true;
        this.price = price;
    }

    public void ParkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.vehicle_type = vehicle.type;
        this.is_empty = false;
        System.out.printf("Vehicle parked at location: %d%n", this.id);
    }

    public void RemoveVehicle(){
        this.is_empty = true;
        this.vehicle = null;
        System.out.printf("Vehicle removed from location: %d%n", this.id);
    }

    public boolean IsEmpty() {
        return this.is_empty;
    }

    public int GetID() {
        return this.id;
    }

    public int GetPrice(){
        return this.price;
    }
}
