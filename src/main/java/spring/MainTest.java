package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ： fjl
 * @date ： 2019/1/16/016 16:08
 */
public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    }
}
