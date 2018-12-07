package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ： fjl
 * @date ： 2018/11/23/023 9:25
 */
//跨域过滤
@CrossOrigin(value = {"*"}, methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PUT}, allowedHeaders = {"*"}, maxAge = 3600, allowCredentials = "true")
@RestController
public class ControllerTest {

    @Autowired
    private SimpleTeacherRepository simpleTeacherRepository;

    @GetMapping(value = "testDispatcher")
    public String testDispatcher(String name) {
        System.out.println(name);
        return "success";
    }

    @GetMapping(value = "user")
    public List<Teacher> user() {
        List<Teacher> userList = simpleTeacherRepository.findAll();
        return userList;
    }
}
