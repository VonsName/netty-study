package thread;

import com.example.demo.NameFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ： fjl
 * @date ： 2018/12/14/014 10:22
 */
public class SemaphoreTest {
    private static final int COUNT = 20;

    private static final Semaphore SEMAPHORE = new Semaphore(3);

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(COUNT);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(COUNT, COUNT, 30L, TimeUnit.SECONDS, queue, new NameFactory("信号量线程池", true));

        for (int i = 0; i < COUNT; i++) {
            final int count = i;
            executor.execute(() -> {
                try {
                    SEMAPHORE.acquire();
                    System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
                    System.out.println("服务号" + count + "启动");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SEMAPHORE.release();
                }
            });
        }
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        executor.shutdown();

    }
}
