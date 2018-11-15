package designer.adapter;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 8:55
 * 接口适配器
 */
public class InterFaceSourceTarget  extends AbstractSourceTaget{

    @Override
    public void print() {
        System.out.println("---InterFaceSourceTarget---print");
    }

    public static void main(String[] args) {
        InterFaceSourceTarget target = new InterFaceSourceTarget();
        target.print();
        target.printer();
    }
}
