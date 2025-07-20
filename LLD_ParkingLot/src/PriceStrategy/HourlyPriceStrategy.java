package PriceStrategy;

import ParkingLot.Ticket.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPriceStrategy extends PriceStrategy{
    public HourlyPriceStrategy(Ticket ticket) {
        super(ticket);
    }

    @Override
    public long Calculate(int spot_price) {
        LocalDateTime now = LocalDateTime.now();
        long total_hours = Duration.between(this.ticket.GetEntryTime(), now).toHours();
        return total_hours*spot_price;
    }
}
