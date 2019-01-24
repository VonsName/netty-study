package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ： fjl
 * @date ： 2019/1/24/024 16:49
 */
@Configuration
//@Import(value = TeacherConfig.class)
//@ImportResource(value = "classpath:bean.xml")
public class SchoolConfig {

    /**
     * 这里Spring会自动从IOC容器中寻找Teacher并DI
     * 前提是必须将Teacher通过xml或者JavaConfig的方式配置到Spring容器中
     *
     * @param teacher
     * @return
     */
    @Bean
    public School school(Teacher teacher) {
        return new School(teacher, "北京大学");
    }
}
