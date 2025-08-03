package utils;

import enums.Direction;

public class Utils {

    public static String GetDirectionString(Direction dir) {
        switch (dir) {
            case Direction.UP -> {
                return "UP";
            }
            case Direction.DOWN -> {
                return "DOWN";
            }
        }
        return "";
    }
    public static void PrintCurrentFloor(int id, int current_floor) {
        System.out.printf("Elevator %d is at floor %d", id, current_floor);
    }

    public static void PrintCurrentFloorAndDirection(int floor, Direction dir) {
        System.out.println(String.format("Elevator is at floor %d moving in direction %s", floor, GetDirectionString(dir)));
    }
}
