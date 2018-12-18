package designer.observer;

/**
 * @author ： fjl
 * @date ： 2018/12/18/018 13:51
 * 实际被观察的对象
 */
public class GreenQuack implements QuackAble {


    private Observable observable;

    public GreenQuack() {
        observable = new QuackObservable(this);
    }


    @Override
    public void quack() {
        System.out.printf("%s", "鸭子呱呱叫了\n");
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObserver() {
        observable.notifyObserver();
    }
}
