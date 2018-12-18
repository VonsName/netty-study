package designer.observer;

/**
 * @author ： fjl
 * @date ： 2018/12/18/018 13:48
 * 抽象被观察者
 */
public interface Observable {
    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObserver();
}
