import enums.VehicleType;

import java.time.LocalDate;

public class VehicleFourWheeler extends Vehicle{

    public VehicleFourWheeler(int id, String name, String vehicle_number, int cc, String color, LocalDate manuf_date) {
        super(id, name, VehicleType.FourWheeler, vehicle_number, cc, color,manuf_date);
    }
}
