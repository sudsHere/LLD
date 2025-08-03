import java.util.ArrayList;

public class ElevatorSystem {
    ArrayList<ElevatorController> elevator_controllers;
    private static ElevatorSystem elevator_system;

    private ElevatorSystem(ArrayList<ElevatorController> elevator_controllers) {
     this.elevator_controllers = elevator_controllers;
    }

    public static ElevatorSystem GetInstance() {
        return elevator_system;
    }

    public static synchronized void Init(ArrayList<ElevatorController> elevator_controllers) {
        if (elevator_system == null ){
            elevator_system = new ElevatorSystem(elevator_controllers);
        } else {
            // throw exception.
        }
    }

    public ElevatorController GetElevatorController(int elevator_id) {
        for(ElevatorController elevatorController : elevator_controllers) {
            if (elevatorController.GetId() == elevator_id){
                return elevatorController;
            }
        }
        return null;
    }
}
