package ParkingLot.ParkingSpace;

import ParkingLot.Vehicle.Vehicle;
import ParkingLot.Types.VehicleType;

public class FourWheelerParkingSpace extends ParkingSpace {

    public FourWheelerParkingSpace(int Id, int price) {
        super(Id, price);
        this.vehicle_type = VehicleType.four_wheeler;
    }
}
