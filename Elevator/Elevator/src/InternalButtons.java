import java.util.ArrayList;

public class InternalButtons {
    ArrayList<Button> buttons;

    public InternalButtons(ArrayList<Button> button) {
        this.buttons = button;
    }

    public void PressButton(int floor, int ele_id) {
        Button button = this.buttons.get(floor);
        button.Activate();
        ElevatorSystem ele_sys = ElevatorSystem.GetInstance();
        ElevatorController ele_ctrl = ele_sys.GetElevatorController(ele_id);
        ele_ctrl.SubmitRequest(floor);
    }

    public void Release(int floor) {
        Button button = this.buttons.get(floor);
        button.Release();
    }
}
