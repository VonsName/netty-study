package designer.bridge;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 9:50
 * 桥接模式
 * 将抽象化和具体实现分开
 * 利用中间类来桥接
 */
public class DriverManager extends AbstractDriverManager {


    @Override
    public void connectToDataBase() {
        if (this.getConnection() instanceof Mysql){
            System.out.println("mysql驱动实现");
        }else if (this.getConnection() instanceof Oracle){
            System.out.println("oracle驱动实现");
        }
        super.connectToDataBase();
    }

    public static void main(String[] args) {

        DriverManager driverManager = new DriverManager();

        Mysql mDriver = new Mysql();
        driverManager.setConnection(mDriver);
        driverManager.connectToDataBase();

        Oracle oDriver = new Oracle();
        driverManager.setConnection(oDriver);
        driverManager.connectToDataBase();
    }
}
