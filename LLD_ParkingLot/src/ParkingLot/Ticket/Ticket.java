package ParkingLot.Ticket;

import ParkingLot.ParkingSpace.ParkingSpace;
import ParkingLot.Vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    Vehicle vehicle;
    LocalDateTime entry_time;
    ParkingSpace parking_space;

    public Ticket(Vehicle vehicle, LocalDateTime entry_time, ParkingSpace parking_space) {
        this.vehicle = vehicle;
        this.entry_time = entry_time;
        this.parking_space = parking_space;
    }

    public LocalDateTime GetEntryTime() {
        return this.entry_time;
    }

    public ParkingSpace GetParkingSpace() {
        return this.parking_space;
    }
}
