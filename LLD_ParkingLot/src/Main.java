import ParkingLot.ParkingSpace.ParkingSpace;
import ParkingLot.ParkingSpace.TwoWheelerParkingSpace;
import ParkingLot.Ticket.Ticket;
import ParkingLot.Types.VehicleType;
import ParkingLot.Vehicle.Vehicle;
import ParkingSpaceManager.ParkingSpaceManagerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingSpaceManagerFactory parking_space_manager_factory = new ParkingSpaceManagerFactory();
        List<ParkingSpace> two_wheeler_parking_space_list = new ArrayList<>();
        List<ParkingSpace> four_wheeler_parking_space_list = new ArrayList<>();
        for(int i=0;i<100;i++){
            if(i%2 == 0){
                ParkingSpace parking_space = new TwoWheelerParkingSpace(i,10);
                two_wheeler_parking_space_list.add(parking_space);
            } else {
                ParkingSpace parking_space = new TwoWheelerParkingSpace(i,5);
                four_wheeler_parking_space_list.add(parking_space);
            }
        }
        parking_space_manager_factory.SetParkingManager(two_wheeler_parking_space_list, VehicleType.two_wheeler);
        parking_space_manager_factory.SetParkingManager(four_wheeler_parking_space_list, VehicleType.four_wheeler);

        Vehicle vehicle = new Vehicle("DAD10",VehicleType.two_wheeler);
        EntryGate entry_gate = new EntryGate(parking_space_manager_factory, vehicle);
        ParkingSpace parking_space = entry_gate.GetParkingSpace();
        Ticket ticket = null;
        if(parking_space != null) {
            entry_gate.ParkVehicle(parking_space);
            ticket = entry_gate.GetTicket(parking_space);
        }

        if (ticket != null) {
            ExitGate exit_gate = new ExitGate(vehicle, ticket, parking_space_manager_factory);
            long total_cost = exit_gate.CalculatePrice();
            exit_gate.RemoveVehicle();
            System.out.printf("total cost for parking = %d%n", total_cost);
        }
    }

}