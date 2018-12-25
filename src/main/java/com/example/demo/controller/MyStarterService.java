package com.example.demo.controller;

import com.von.simple.StarterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ： fjl
 * @date ： 2018/12/25/025 13:53
 */
@Service
public class MyStarterService {

    @Autowired
    private StarterService starterService;

    public String[] testStarter1() {
        System.out.println("MyStarterService");
        return starterService.split(",");
    }
}
