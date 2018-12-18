package designer.observer;

/**
 * @author ： fjl
 * @date ： 2018/12/18/018 13:50
 * 抽象被观察者
 */
public interface QuackAble extends Observable {

    /**
     * 继承被观察对象
     */
    void quack();
}
