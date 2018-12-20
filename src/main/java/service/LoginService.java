package service;

/**
 * @author ： fjl
 * @date ： 2018/12/20/020 14:10
 */
public interface LoginService {

    /**
     *
     * @param password
     * @param username
     * @return
     */
    boolean login(String password,String username);

    void logout(int a);

    int add(String username);
}
