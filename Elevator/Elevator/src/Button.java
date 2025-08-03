public class Button {
    boolean is_pressed;
    int floor;

    public Button(int floor) {
        this.is_pressed = false;
        this.floor = floor;
    }

    public void Activate() {
        this.is_pressed = true;
    }

    public void Release() {
        this.is_pressed = false;
    }
}
