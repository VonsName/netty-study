package command;

/**
 * @author ： fjl
 * @date ： 2018/11/23/023 15:42
 */
public class LightState extends AbstractLightState {

    public LightState() {
        this.setOn(false);
    }

    @Override
    public void turnOn() {
        this.setOn(true);
        System.out.println("开启oning...");

    }

    @Override
    public void turnOff() {
        this.setOn(false);
        System.out.println("关闭offing...");
    }
}
