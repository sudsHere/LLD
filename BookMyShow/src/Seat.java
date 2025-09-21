public class Seat {
    int number;
    boolean isOccupied;
    SeatType type;
    int price;

    public Seat(int number, SeatType type, int price) {
        this.number = number;
        this.isOccupied = false;
        this.type = type;
        this.price = price;
    }

    public int getSeatNumber() {
        return this.number;
    }

    public boolean isSeatOccupied() {
        return this.isOccupied;
    }

    public void changeOccupyStatus(boolean status) {
        this.isOccupied = status;
    }
}
