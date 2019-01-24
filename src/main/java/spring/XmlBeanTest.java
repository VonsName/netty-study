package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ： fjl
 * @date ： 2019/1/24/024 16:30
 */
public class XmlBeanTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Teacher bean = context.getBean(Teacher.class);
        System.out.println(bean);
    }
}
