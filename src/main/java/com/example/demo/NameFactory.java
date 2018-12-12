package com.example.demo;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ： fjl
 * @date ： 2018/12/12/012 9:25
 */
public class NameFactory implements ThreadFactory {
    private String prefix;
    private AtomicInteger id = new AtomicInteger();
    private Boolean daemon;


    public NameFactory(String prefix, Boolean daemon) {
        this.prefix = prefix;
        this.daemon = daemon;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread t = new Thread(runnable, prefix + id.incrementAndGet());
        if (this.daemon) {
            t.setDaemon(true);
        } else {
            t.setDaemon(false);
        }
        return t;
    }
}
