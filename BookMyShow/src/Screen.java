public class Screen {
    int screen_id;
    Seat[] seats;
    int total_seats;

    public Screen(int screen_id, int total_seats){
        this.screen_id = screen_id;
        this.total_seats = total_seats;
        this.seats = new Seat[this.total_seats];
        for(int i=0;i<total_seats;i++){
            if (i<20) {
                seats[i] = new Seat(i+1, SeatType.SILVER, 120);
            } else if (i<40) {
                seats[i] = new Seat(i+1, SeatType.GOLD, 200);
            } else {
                seats[i] = new Seat(i+1, SeatType.PLATINUM, 250);
            }
        }
    }

    public Seat[] getSeats() {
        return this.seats;
    }

    public int getScreenId() {
        return this.screen_id;
    }
}
