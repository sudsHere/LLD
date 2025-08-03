import enums.Direction;

public class ExternalButton extends Button{
    ExternalButtonDispatcher ext_btn_dispatcher;

    public ExternalButton(int floor, ExternalButtonDispatcher dispatcher) {
        super(floor);
        this.ext_btn_dispatcher = dispatcher;
    }

    public void PressButton(Direction dir) {
        Activate();
        this.ext_btn_dispatcher.SubmitRequest(floor, dir);
    }

    public void ReleaseButton(){
        Release();
    }
}
