package designer.proxy;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 9:06
 */
public class TargetSource implements ProxyAble {

    private ProxySource proxySource;

    public TargetSource() {
        this.proxySource = new ProxySource();
    }

    @Override
    public void proxy() {
        before();
        proxySource.proxy();
        after();
    }

    private void before() {
        System.out.println("before---proxy---");
    }

    private void after() {
        System.out.println("after---proxy---");
    }

    public static void main(String[] args) {
        TargetSource source = new TargetSource();
        source.proxy();
    }
}
