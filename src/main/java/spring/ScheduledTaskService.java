package spring;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ： fjl
 * @date ： 2019/1/16/016 16:02
 */
@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat data = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTime() {
        System.out.println("每隔5秒执行一次" + data.format(new Date()));
    }

    @Scheduled(cron = "0 11 16 ? * *")
    public void fixTimeExecution() {
        System.out.println("在指定时间：" + data.format(new Date()) + "执行");
    }
}
