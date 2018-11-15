package designer.strategy;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 15:06
 */
public class Devide implements Calculator {


    @Override
    public int calculate(int a, int b) {
        return b == 0 ? 0 : a / b;
    }


}
