import enums.Direction;

public class Floor {
    int floor_id;
    ExternalButton external_button;

    public Floor(int floor_id, ExternalButtonDispatcher ext_btn_dis) {
        this.floor_id = floor_id;
        this.external_button = new ExternalButton(floor_id, ext_btn_dis);
    }

    public int GetFloor(){
        return this.floor_id;
    }

    public void PressExternalButton(Direction dir) {
        this.external_button.PressButton(dir);
    }
}
