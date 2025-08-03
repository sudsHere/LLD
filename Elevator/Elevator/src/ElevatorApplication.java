import enums.Direction;

import java.util.ArrayList;

public class ElevatorApplication {
    ArrayList<Floor> floors;

    public void Init(int floors, int number_of_elevators){
        this.floors = new ArrayList<>();
        ArrayList<Button> buttons = new ArrayList<>();

        ArrayList<ElevatorController> elevator_controllers = new ArrayList<>();

        for(int i=0; i< floors; i++){
            buttons.add(new Button(i));
        }

        for(int i=0;i<number_of_elevators;i++){
            InternalButtons internal_buttons = new InternalButtons(buttons);
            elevator_controllers.add(new ElevatorController(internal_buttons, i));
        }

        // initialize elevator system
        ElevatorSystem.Init(elevator_controllers);

        // initialize external buttons and floors
        ExternalButtonDispatcher ext_btn_dis = new ExternalButtonDispatcher(elevator_controllers);
        for(int i=0; i< floors; i++){
            Floor floor = new Floor(i,ext_btn_dis);
            this.floors.add(floor);
        }
    }

    public void RunElevator() {
        // external button pressed at floor 2
        this.floors.get(5).PressExternalButton(Direction.UP);

        // internal button pressed for elevator 2
        ElevatorSystem ele_sys = ElevatorSystem.GetInstance();
        ElevatorController ele_ctrl = ele_sys.GetElevatorController(2);
        ElevatorCar ele_car = ele_ctrl.GetElevatorCar();
        ele_car.ClickInternalButton(1);
    }
}
