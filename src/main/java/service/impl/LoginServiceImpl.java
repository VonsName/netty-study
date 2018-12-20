package service.impl;

import org.springframework.stereotype.Service;
import service.LoginService;

/**
 * @author ： fjl
 * @date ： 2018/12/20/020 14:10
 */
@Service
public class LoginServiceImpl implements LoginService {
    private static final String PWD = "admin123";

    @Override
    public boolean login(String password, String username) {
        if (PWD.equalsIgnoreCase(password)) {
            System.out.printf("姓名：%s登录成功", username);
            return true;
        } else {
            System.out.printf("姓名：%s登录失败,密码错误", username);
            return false;
        }
    }

    @Override
    public void logout(int a) {
        System.out.printf("logout:%d", a);
    }

    @Override
    public int add(String username) {
        System.out.printf("新增：%s", username);
        return 0;
    }
}
