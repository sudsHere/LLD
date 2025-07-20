package PriceStrategy;

import ParkingLot.Ticket.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class MinutePriceStrategy extends PriceStrategy{
    public MinutePriceStrategy(Ticket ticket) {
        super(ticket);
    }


    @Override
    public long Calculate(int spot_price) {
        LocalDateTime now = LocalDateTime.now();
        long total_minutes = Duration.between(this.ticket.GetEntryTime(), now).toMinutes();
        return total_minutes*spot_price;
    }
}
