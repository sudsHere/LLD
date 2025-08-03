import enums.Direction;

import java.util.ArrayList;

public class ExternalButtonDispatcher {
    ArrayList<ElevatorController> elevator_controllers;
    int no_of_elevators;

    public ExternalButtonDispatcher(ArrayList<ElevatorController> elevator_controllers) {
        this.elevator_controllers = elevator_controllers;
        this.no_of_elevators = this.elevator_controllers.size();
    }

    public void SubmitRequest(int floor, Direction dir) {
        // get an elevator to submit a request to.
        ElevatorController ele_car_controller;
        ele_car_controller = this.elevator_controllers.get(floor % this.no_of_elevators);

        ele_car_controller.SubmitRequest(floor);
    }
}
