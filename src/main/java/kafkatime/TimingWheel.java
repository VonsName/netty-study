package kafkatime;

/**
 * @author ： fjl
 * @date ： 2018/12/14/014 14:28
 */
public class TimingWheel {

    /**
     * 一个时间槽的时间
     */
    private long tickMs;

    /**
     * 时间轮大小
     */
    private int wheelSize;

    /**
     * 时间跨度
     */
    private long interval;

    /**
     * 槽
     */
    private Bucket[] buckets;

    /**
     * 时间轮指针
     */
    private long currentTimestamp;

    /**
     * 上一层时间轮
     */
    private volatile TimingWheel overflowWheel;

    public TimingWheel(long tickMs, int wheelSize, long currentTimestamp) {
        this.tickMs = tickMs;
        this.wheelSize = wheelSize;
        this.buckets = new Bucket[wheelSize];
        this.interval = tickMs * wheelSize;
        this.currentTimestamp = currentTimestamp;
        for (int i = 0; i < wheelSize; i++) {
            buckets[i] = new Bucket();
        }
    }
}
