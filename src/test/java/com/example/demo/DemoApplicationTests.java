package com.example.demo;

import com.example.demo.controller.SimpleTeacherRepository;
import com.example.demo.controller.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private SimpleTeacherRepository simpleTeacherRepository;

    @Test
    public void testJpa1() {
        List<Teacher> userList = simpleTeacherRepository.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void testJpa2() {
        Teacher teacher = new Teacher();
        teacher.setUsername("王二麻子");
        teacher.setPassword("adadasdas");
        simpleTeacherRepository.save(teacher);
    }

    @Test
    public void testJpa3() {
        if (simpleTeacherRepository.existsById(1)) {
            simpleTeacherRepository.deleteById(1);
        }
    }

    @Test
    public void testJpa4() {
        System.out.println(simpleTeacherRepository.findById(2));
    }

    @Test
    public void testJpa5() {
        simpleTeacherRepository.findByUsername("lisi").forEach(System.out::println);
    }

    @Test
    public void testJpa6() {
        System.out.println(simpleTeacherRepository.existsById(1));
    }
}
