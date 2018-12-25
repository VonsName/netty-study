package mvc;

/**
 * @author ： fjl
 * @date ： 2018/12/21/021 9:58
 */
public interface BeatModelInterface {

    /**
     * 初始化
     */
    void initialize();

    /**
     * on
     */
    void on();

    /**
     * off
     */
    void off();

    /**
     * set
     * @param bpm
     */
    void setBpm(int bpm);

    /**
     * get
     */
    void getBpm();

    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(BeatObserver observer);

    /**
     * 移除观察者
     * @param observer
     */
    void removeObserver(BeatObserver observer);

    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(BpmObserver observer);

    /**
     * 移除观察者
     * @param observer
     */
    void removeObserver(BpmObserver observer);
}
