package ParkingSpaceManager;

import ParkingLot.ParkingSpace.ParkingSpace;
import ParkingLot.Vehicle.Vehicle;

import java.util.List;

public class ParkingSpaceManager {
    List<ParkingSpace> parkingSpaceList;
    int parkingSpaceLeft;

    public ParkingSpaceManager(List<ParkingSpace> parkingSpaceList) {
        this.parkingSpaceList = parkingSpaceList;
        this.parkingSpaceLeft = parkingSpaceList.size();
    }

    public ParkingSpace GetParkingSpace() {
        for(ParkingSpace parking_space: this.parkingSpaceList) {
            if(parking_space.IsEmpty()) {
                return parking_space;
            }
        }
        return null;
    }

    public void ParkVehicle(ParkingSpace parking_space, Vehicle vehicle) {
        parking_space.ParkVehicle(vehicle);
    }

    public void RemoveVehicle(ParkingSpace parking_space) {
        parking_space.RemoveVehicle();
    }
}
