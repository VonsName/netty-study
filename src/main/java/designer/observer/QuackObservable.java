package designer.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ： fjl
 * @date ： 2018/12/18/018 13:53
 * 被观察对象辅助类
 */
public class QuackObservable implements Observable {

    private List<Observer> observers = new ArrayList<>();

    private Observable observable;

    public QuackObservable(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.notificated(observable);
        }
    }
}
