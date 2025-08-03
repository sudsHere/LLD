import enums.Direction;

import static utils.Utils.PrintCurrentFloorAndDirection;

public class Display {
    int floor;
    Direction dir;

    Display(int floor, Direction dir){
        this.floor = floor;
        this.dir = dir;
    }

    public void UpdateDisplay(int floor, Direction dir) {
        this.floor = floor;
        this.dir = dir;
        PrintCurrentFloorAndDirection(floor, dir);
    }
}
