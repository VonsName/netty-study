package command;

/**
 * @author ： fjl
 * @date ： 2018/11/23/023 15:41
 */
public abstract class AbstractLightState {

    private boolean on;

    public boolean isOn() {
        return on;
    }

    public void turnOn() {
    }

    public void turnOff() {
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
