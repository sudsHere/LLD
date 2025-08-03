import enums.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class ElevatorController {
    ElevatorCar elevator_car;
    int id;
    // for going up we need min heap
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // for going down we need max heap
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public ElevatorController(InternalButtons internal_buttons, int Id) {
        this.elevator_car = new ElevatorCar(Id, internal_buttons);
        this.id = Id;
    }

    public int GetId() {
        return this.id;
    }

    public void SubmitRequest(int request_floor){
        Direction request_direction = this.elevator_car.GetCurrentFloor() - request_floor > 0 ?
                Direction.DOWN : Direction.UP;
        if(elevator_car.GetDirection() != request_direction) {
            System.out.print("Cannot fulfill request, lift going in other direction");
        } else {
            if (this.elevator_car.GetDirection() == Direction.UP) {
                minHeap.add(request_floor);
            } else {
                maxHeap.add(request_floor);
            }
        }
        RunElevator();
    }

    public void RunElevator() {
        while (!this.maxHeap.isEmpty() || !this.minHeap.isEmpty()) {
            while(this.elevator_car.GetDirection() == Direction.UP && !this.minHeap.isEmpty()){
                int floor = this.minHeap.poll();
                this.elevator_car.Move(floor, Direction.UP);
            }
            if(this.minHeap.isEmpty()) {
                this.elevator_car.SetDirection(Direction.DOWN);
            }

            while(this.elevator_car.GetDirection() == Direction.DOWN && !this.minHeap.isEmpty()) {
                int floor = this.maxHeap.poll();
                this.elevator_car.Move(floor, Direction.DOWN);
            }
            if(this.minHeap.isEmpty()) {
                this.elevator_car.SetDirection(Direction.UP);
            }
        }

    }

    public ElevatorCar GetElevatorCar() {
        return this.elevator_car;
    }

}
