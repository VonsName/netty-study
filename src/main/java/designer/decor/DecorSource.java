package designer.decor;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 8:59
 * 装饰者模式 用于增强已有类的方法 装饰者和被装饰者都实现相同的接口或者抽象类
 * 被装饰对象
 */
public class DecorSource extends AbstractDecorSource{
    @Override
    public void decor(){
        System.out.println("===DecorSource===");
    }
}
