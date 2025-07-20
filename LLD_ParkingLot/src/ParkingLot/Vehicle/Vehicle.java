package ParkingLot.Vehicle;

import ParkingLot.Types.VehicleType;

public class Vehicle {
    String vehicle_no;
    public VehicleType type;

    public Vehicle(String vehicle_no, VehicleType type){
        this.vehicle_no = vehicle_no;
        this.type = type;
    }
}
