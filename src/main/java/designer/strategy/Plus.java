package designer.strategy;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 15:04
 */
public class Plus  implements Calculator {


    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
