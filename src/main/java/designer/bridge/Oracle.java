package designer.bridge;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 9:49
 */
public class Oracle implements Connection{


    @Override
    public void connectToDataBase() {
        System.out.println("---Oracle---");
    }
}
