package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.demo"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    {
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 2000, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new NameFactory("线程池", true));
    }
}
