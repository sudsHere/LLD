package CalculatePrice;

import ParkingLot.Ticket.Ticket;
import PriceStrategy.PriceStrategy;

public abstract class CalculatePrice {
    Ticket ticket;
    PriceStrategy strategy;

    CalculatePrice(PriceStrategy strategy, Ticket ticket){
        this.strategy = strategy;
        this.ticket = ticket;
    }

    public long GetCost() {
        return this.strategy.Calculate(this.ticket.GetParkingSpace().GetPrice());
    }

}
