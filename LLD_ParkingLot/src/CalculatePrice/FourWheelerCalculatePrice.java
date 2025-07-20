package CalculatePrice;

import ParkingLot.Ticket.Ticket;
import PriceStrategy.MinutePriceStrategy;

public class FourWheelerCalculatePrice extends CalculatePrice{

    public FourWheelerCalculatePrice(Ticket ticket) {
        super(new MinutePriceStrategy(ticket), ticket);
    }

    public long GetCost() {
        return super.GetCost();
    }
}
