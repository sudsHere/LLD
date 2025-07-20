package ParkingLot.ParkingSpace;

import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Types.VehicleType;

public class TwoWheelerParkingSpace extends ParkingSpace {

    public TwoWheelerParkingSpace(int Id, int price) {
        super(Id, price);
        this.vehicle_type = VehicleType.two_wheeler;
    }
}
