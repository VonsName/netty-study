package spring;

/**
 * @author ： fjl
 * @date ： 2019/1/24/024 16:49
 */
public class School {
    private Teacher teacher;
    private String name;

    public School(Teacher teacher, String name) {
        this.teacher = teacher;
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
