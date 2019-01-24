package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author ： fjl
 * @date ： 2019/1/24/024 16:54
 */
@Configuration
public class TeacherConfig {

    @Bean
    public Teacher teacher() {
        return new Teacher("lisi", "waiwu", Arrays.asList("aaa", "bbb"));
    }
}
