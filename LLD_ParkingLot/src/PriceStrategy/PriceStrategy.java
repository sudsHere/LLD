package PriceStrategy;

import ParkingLot.Ticket.Ticket;

public abstract class PriceStrategy {

    Ticket ticket;

    PriceStrategy(Ticket ticket) {
        this.ticket = ticket;
    }

    public long Calculate(int spot_price) {
        return spot_price;
    }

}
