package spring;

import java.util.List;

/**
 * @author ： fjl
 * @date ： 2019/1/24/024 16:23
 */
public class Teacher {
    private String name;
    private String course;
    private List<String> stus;

    public Teacher(String name, String course, List<String> stus) {
        this.name = name;
        this.course = course;
        this.stus = stus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<String> getStus() {
        return stus;
    }

    public void setStus(List<String> stus) {
        this.stus = stus;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", stus=" + stus +
                '}';
    }
}
