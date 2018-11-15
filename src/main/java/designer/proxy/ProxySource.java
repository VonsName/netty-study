package designer.proxy;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 9:05
 * 代理模式 和 装饰者模式感觉差不多
 * 都是增强已有的方法
 * 接口代理：代理对象和被代理对象都实现同一个接口
 * 类代理：代理对象和被代理对象都继承相同的一个类
 */
public class ProxySource implements ProxyAble{


    @Override
    public void proxy() {
        System.out.println("---ProxySource---");
    }
}
