package command;

/**
 * @author ： fjl
 * @date ： 2018/11/23/023 15:37
 */
public class AbstractCommand implements Command{

    protected Light light;

    public AbstractCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {}
}
