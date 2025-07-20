package CalculatePrice;

import ParkingLot.Ticket.Ticket;
import ParkingLot.Types.VehicleType;

public class CalculatePriceFactory {

    public CalculatePrice GetCalculatePrice(VehicleType type, Ticket ticket) {
        switch (type) {
            case two_wheeler -> {
                return new TwoWheelerCalculatePrice(ticket);
            }
            case four_wheeler -> {
                return new FourWheelerCalculatePrice(ticket);
            }
        }
        return null;
    }
}
