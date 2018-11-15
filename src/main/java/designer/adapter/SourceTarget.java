package designer.adapter;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 8:47
 * 类适配器模式
 */
public class SourceTarget extends Source implements Target{


    @Override
    public void printer() {
        System.out.println("====SourceTarget====");
    }

    public static void main(String[] args) {
        SourceTarget target = new SourceTarget();
        target.printer();
        target.print();
    }
}
