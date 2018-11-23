package command;

/**
 * @author ： fjl
 * @date ： 2018/11/23/023 15:36
 */
public class PinkLight implements Light {

    private static AbstractLightState lightState;

    public PinkLight() {
        lightState = new LightState();
    }

    @Override
    public void switchs() {
        if (lightState.isOn()) {
            lightState.turnOff();
        } else {
            lightState.turnOn();
        }
    }
}
