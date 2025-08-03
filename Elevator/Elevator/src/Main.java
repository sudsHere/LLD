//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ElevatorApplication elevator_application = new ElevatorApplication();
        elevator_application.Init(10,3);
        elevator_application.RunElevator();
    }
}