package ParkingSpaceManager;

import ParkingLot.ParkingSpace.ParkingSpace;
import ParkingLot.Types.VehicleType;

import java.util.List;

public class ParkingSpaceManagerFactory {
    ParkingSpaceManager two_wheeler_parking_space_manager;
    ParkingSpaceManager four_wheeler_parking_space_manager;

    public void SetParkingManager(List<ParkingSpace> parking_space, VehicleType type) {
        switch (type) {
            case two_wheeler -> this.two_wheeler_parking_space_manager = new TwoWheelerParkingSpaceManager(parking_space);
            case four_wheeler -> this.four_wheeler_parking_space_manager = new FourWheelerParkingSpaceManager(parking_space);
        }

    }

    public ParkingSpaceManager GetParkingSpaceManager(VehicleType vehicle_type) {
        switch (vehicle_type) {
            case two_wheeler -> {
                return this.two_wheeler_parking_space_manager;
            }
            case four_wheeler -> {
                return this.four_wheeler_parking_space_manager;
            }
        }
        return null;
    }
}
