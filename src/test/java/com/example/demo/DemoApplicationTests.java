package com.example.demo;

import com.example.demo.controller.SimpleTeacherRepository;
import com.example.demo.controller.Teacher;
import designer.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.AopTestUtils;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import service.LoginService;
import service.UserService;

import java.net.URI;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTests {

//    @Autowired
//    private WebApplicationContext context;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//
//    @Test
//    public void mockTest1() throws Exception {
//        String res = mockMvc.perform(MockMvcRequestBuilders
//                .request(HttpMethod.GET, new URI(""))
//                .accept(MediaType.ALL)
//                .param("aa", "22"))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn().getResponse().toString();
//    }

    @Autowired
    private UserService userService;
    @Mock
    LoginService loginService;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void mockitoTest() {

        UserService targetObject = AopTestUtils.getTargetObject(userService);

        ReflectionTestUtils.setField(targetObject, "loginService", loginService);
        boolean b = verify(targetObject.add("admin", "admin123"));
    }


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
