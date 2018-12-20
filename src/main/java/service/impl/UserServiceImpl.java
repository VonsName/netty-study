package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.LoginService;
import service.UserService;

/**
 * @author ： fjl
 * @date ： 2018/12/20/020 14:10
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private LoginService loginService;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public boolean add(String username, String password) {
        if (loginService.login(password, username)) {
            System.out.printf("姓名：%s用户信息操作成功\n", username);
            return true;
        } else {
            System.out.printf("姓名：%s用户信息操作失败\n", username);
            return false;
        }
    }
}
