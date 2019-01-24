package spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ： fjl
 * @date ： 2019/1/24/024 16:52
 */
@Configuration
//组合多个JavaConfig配置
@Import(value = {SchoolConfig.class, TeacherConfig.class})
//@ImportResource(value = "classpath:bean.xml")
public class BothConfig {
}
