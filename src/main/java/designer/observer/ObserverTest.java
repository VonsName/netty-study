package designer.observer;

/**
 * @author ： fjl
 * @date ： 2018/12/18/018 14:08
 */
public class ObserverTest {

    public static void main(String[] args) {
        //观察者
        QuackObserver quackObserver = new QuackObserver();
        //被观察者
        GreenQuack greenQuack = new GreenQuack();
        //注册观察者
        greenQuack.registerObserver(quackObserver);
        greenQuack.quack();
//        greenQuack.notifyObserver();
    }
}
