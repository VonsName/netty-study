package designer.bridge;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 9:57
 */
public abstract class AbstractDriverManager {

    private Connection connection;


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void connectToDataBase(){
        connection.connectToDataBase();
    }
}
