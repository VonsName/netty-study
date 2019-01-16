package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.demo"})
@EnableDiscoveryClient
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    {
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 2000, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new NameFactory("线程池", true));
    }

    @RestController
    static class TestContronller {
        @GetMapping(value = "/hello")
        public String hello(@RequestParam String name) {
            System.out.println(name);
            return "hello" + name;
        }
    }
}
