package mock;

import designer.User;

/**
 * @author ： fjl
 * @date ： 2018/12/20/020 16:53
 */
public class ArticleManager {
    private User user;
    private ArticleDataBase dataBase;

    public ArticleManager(User user, ArticleDataBase dataBase) {
        this.user = user;
        this.dataBase = dataBase;
    }

    public void initialize(String username) {
        dataBase.add(username);
        System.out.println(user.getNo()+"===");
    }
}
