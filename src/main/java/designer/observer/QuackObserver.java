package designer.observer;

/**
 * @author ： fjl
 * @date ： 2018/12/18/018 14:00
 */
public class QuackObserver implements Observer {
    @Override
    public void notificated(Observable observable) {
        System.out.printf("我观察到%s呱呱叫了\n", observable);
    }
}
