package command;

/**
 * @author ： fjl
 * @date ： 2018/11/23/023 15:58
 * 命令模式
 */
public class RemoteControl {
    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressed() {
        command.execute();
    }
}
