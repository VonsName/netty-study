package command;

/**
 * @author ： fjl
 * @date ： 2018/11/23/023 15:35
 */
public class LightOnCommand extends AbstractCommand {


    public LightOnCommand(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        light.switchs();
    }
}
