import CalculatePrice.CalculatePrice;
import CalculatePrice.CalculatePriceFactory;
import ParkingLot.Ticket.Ticket;
import ParkingLot.Vehicle.Vehicle;
import ParkingSpaceManager.ParkingSpaceManager;
import ParkingSpaceManager.ParkingSpaceManagerFactory;

public class ExitGate {
    Vehicle vehicle;
    Ticket ticket;
    ParkingSpaceManagerFactory parking_space_manager_factory;
    ParkingSpaceManager parking_space_manager;

    public ExitGate(Vehicle vehicle, Ticket ticket, ParkingSpaceManagerFactory parking_space_manager_factory) {
        this.vehicle = vehicle;
        this.ticket = ticket;
        this.parking_space_manager_factory = parking_space_manager_factory;
    }

    public long CalculatePrice() {
        CalculatePriceFactory calculate_price_factory = new CalculatePriceFactory();
        CalculatePrice calculate_price = calculate_price_factory.GetCalculatePrice(this.vehicle.type, ticket);
        return calculate_price.GetCost();
    }

    public void RemoveVehicle() {
        parking_space_manager = parking_space_manager_factory.GetParkingSpaceManager(this.vehicle.type);
        parking_space_manager.RemoveVehicle(ticket.GetParkingSpace());
    }
}
