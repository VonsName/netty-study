package designer.back;

/**
 * @author ： fjl
 * @date ： 2018/12/18/018 14:24
 */
public class Employee {

    private RollBack rollBack;

    public Employee(RollBack rollBack) {
        this.rollBack = rollBack;
    }

    public void answer() {
        System.out.printf("这次工作已经完成,结果：%d\n", 3 + 3);
        rollBack.back(this);
    }

    public static void main(String[] args) {
        Boss boss = new Boss();
        Employee employee = new Employee(boss);
        boss.setEmployee(employee);
        boss.ask();
    }
}
