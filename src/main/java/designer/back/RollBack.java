package designer.back;

/**
 * @author ： fjl
 * @date ： 2018/12/18/018 14:23
 */
public interface RollBack {
    /**
     * 回调函数
     * @param employee
     */
    void back(Employee employee);
}
