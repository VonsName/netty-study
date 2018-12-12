package thread;

import com.example.demo.NameFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ： fjl
 * @date ： 2018/12/12/012 13:16
 */
public class ThreadTest {

    private static ScheduledExecutorService scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NameFactory("定时任务", true));

    public static void main(String[] args) {
        //定时任务执行器
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(() -> {
            AtomicInteger atomicInteger = new AtomicInteger();
            System.out.println(atomicInteger.incrementAndGet());
            System.out.println("seconds");
        }, 1000, 1000, TimeUnit.MILLISECONDS);

        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
//        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.setThreadNamePrefix();
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
    }
}
