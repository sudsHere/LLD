import enums.Direction;

public class ElevatorCar {
    int id;
    int current_floor;
    Display display;
    InternalButtons internal_buttons;
    State elevtor_state;
    Direction curr_direction;

    public ElevatorCar(int id, InternalButtons internal_buttons) {
        this.id = id;
        this.curr_direction = Direction.UP;
        this.current_floor = 0;
        this.elevtor_state = State.IDLE;
        this.display = new Display(this.current_floor, this.curr_direction);
        this.internal_buttons = internal_buttons;
    }
    public void Move(int floor, Direction dir) {
        this.elevtor_state = State.MOVING;
        this.current_floor = floor;
        this.curr_direction = dir;
        internal_buttons.Release(floor);
        this.display.UpdateDisplay(this.current_floor, this.curr_direction);
        this.elevtor_state = State.IDLE;
    }

    public void ClickInternalButton(int floor) {
        internal_buttons.PressButton(floor, this.id);
    }

    public Direction GetDirection() {
        return this.curr_direction;
    }

    public int GetCurrentFloor() {
        return this.current_floor;
    }

    public void SetDirection(Direction dir) {
        this.curr_direction = dir;
    }
}
