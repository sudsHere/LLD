import ParkingLot.ParkingSpace.ParkingSpace;
import ParkingLot.Ticket.Ticket;
import ParkingLot.Vehicle.Vehicle;
import ParkingSpaceManager.ParkingSpaceManager;
import ParkingSpaceManager.ParkingSpaceManagerFactory;

import java.time.LocalDateTime;

public class EntryGate {
    Vehicle vehicle;
    ParkingSpaceManagerFactory parking_space_manager_factory;
    ParkingSpaceManager parking_space_manager;

    EntryGate(ParkingSpaceManagerFactory parking_space_manager_factory, Vehicle vehicle) {
        this.vehicle = vehicle;
        this.parking_space_manager_factory = parking_space_manager_factory;
        this.parking_space_manager = parking_space_manager_factory.GetParkingSpaceManager(this.vehicle.type);
    }

    public ParkingSpace GetParkingSpace(){
        ParkingSpace parking_space = parking_space_manager.GetParkingSpace();
        if (parking_space == null) {
            System.out.println("No parking spot available");
            return null;
        } else {
            return parking_space;
        }
    }

    public void ParkVehicle(ParkingSpace parking_space) {
        parking_space_manager.ParkVehicle(parking_space, this.vehicle);
    }

    public Ticket GetTicket(ParkingSpace parking_space) {
        return new Ticket(this.vehicle, LocalDateTime.now(), parking_space);
    }
}
