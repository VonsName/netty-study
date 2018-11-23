package command;

/**
 * @author ： fjl
 * @date ： 2018/11/23/023 15:58
 * 命令模式
 */
public class CommandTest {
    public static void main(String[] args) {
        Light light = new PinkLight();
        Command command = new LightOnCommand(light);
        RemoteControl control = new RemoteControl();
        control.setCommand(command);
        control.pressed();
        control.pressed();
        control.pressed();
        control.pressed();
    }
}
