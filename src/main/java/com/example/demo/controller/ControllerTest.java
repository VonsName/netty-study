package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： fjl
 * @date ： 2018/11/23/023 9:25
 */
@RestController
public class ControllerTest {

    @GetMapping(value = "testDispatcher")
    public String testDispatcher(String name) {
        System.out.println(name);
        return "success";
    }
}