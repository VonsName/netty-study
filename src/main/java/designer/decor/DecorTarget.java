package designer.decor;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 9:00
 * 装饰对象
 * 持有被装饰对象
 */
public class DecorTarget {

    private DecorSource decorSource;

    public DecorTarget(DecorSource decorSource) {
        this.decorSource = decorSource;
    }

    public void decor() {
        System.out.println("before---decor---");
        decorSource.decor();
        System.out.println("after---decor---");
    }

    public static void main(String[] args) {
        DecorTarget target = new DecorTarget(new DecorSource());
        target.decor();
    }
}
