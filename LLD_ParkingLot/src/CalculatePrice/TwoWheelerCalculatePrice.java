package CalculatePrice;

import ParkingLot.Ticket.Ticket;
import PriceStrategy.HourlyPriceStrategy;

public class TwoWheelerCalculatePrice extends CalculatePrice{

    public TwoWheelerCalculatePrice(Ticket ticket) {
        super(new HourlyPriceStrategy(ticket), ticket);
    }

    public long GetCost() {
        return super.GetCost();
    }
}
