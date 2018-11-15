package designer.strategy;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 15:23
 */
public class Strategy {

    private Calculator calculator;

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public int calculate(int a, int b) {
        return calculator.calculate(a, b);
    }

    public static void main(String[] args) {
        Strategy strategy = new Strategy();

        Calculator cal = new Devide();
        strategy.setCalculator(cal);
        System.out.println(strategy.calculate(1, 2));

        cal = new Minus();
        strategy.setCalculator(cal);
        System.out.println(strategy.calculate(3, 2));

        cal = new Plus();
        strategy.setCalculator(cal);
        System.out.println(strategy.calculate(5, 2));
    }
}
