public class Cell {
    boolean is_occupied;
    Jump jump;

    public Cell() {
        this.is_occupied = false;
        this.jump = new Jump(-1,-1);
    }

    public boolean IsOccupied() {
        return this.is_occupied;
    }

    public void SetJump(Jump jump) {
        this.jump = jump;
        this.is_occupied = true;
    }
}
