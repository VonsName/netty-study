package designer.back;

/**
 * @author ： fjl
 * @date ： 2018/12/18/018 14:23
 */
public class Boss implements RollBack {


    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void ask() {
        employee.answer();
    }


    @Override
    public void back(Employee employee) {
        System.out.printf("%s完成了工作\n", employee);
    }
}
