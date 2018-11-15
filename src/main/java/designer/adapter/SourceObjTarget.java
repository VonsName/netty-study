package designer.adapter;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 8:51
 * 对象适配器模式
 * 持有被适配的对象
 */
public class SourceObjTarget implements Target{

    private Source source;

    public SourceObjTarget(Source source) {
        this.source = source;
    }

    @Override
    public void print() {
        source.print();
    }

    @Override
    public void printer() {
        System.out.println("===SourceObjTarget===");
    }

    public static void main(String[] args) {
        SourceObjTarget target = new SourceObjTarget(new Source());
        target.print();
        target.printer();
    }
}
