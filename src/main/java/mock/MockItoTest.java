package mock;

import com.sun.xml.internal.bind.v2.TODO;
import designer.User;
import javafx.util.Callback;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.stereotype.Service;
import org.springframework.test.util.ReflectionTestUtils;
import service.LoginService;
import service.impl.LoginServiceImpl;
import service.impl.UserServiceImpl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

/**
 * @author ： fjl
 * @date ： 2018/12/20/020 11:17
 */
@Service
public class MockItoTest {


    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    /**
     * 参数为any或者anyString
     */
    @Test
    public void mockitoTest1() {

        LoginService mock = Mockito.mock(LoginService.class);
        when(mock.login(any(), anyString())).thenReturn(true);
        //Calling real methods is only possible when mocking non abstract method
//        when(mock.login("admin123", "LISI")).thenCallRealMethod();

        UserServiceImpl userService = new UserServiceImpl();
        ReflectionTestUtils.setField(userService, "loginService", mock);
        boolean add = userService.add("admin", "LISI");
        System.out.println(add);
        Assert.assertTrue("用户登录失败", add);
    }

    /**
     *
     */
    @Test
    @SuppressWarnings("unchecked")
    public void mockitoTest2() {
        Comparable mock = Mockito.mock(Comparable.class);
        when(mock.compareTo("123")).thenReturn(1);
        when(mock.compareTo("456")).thenReturn(2);
        Assert.assertEquals("操作失败", 2, mock.compareTo("456"));
    }

    /**
     * 返回多个值
     */
    @Test
    public void mockitoTest3() {
        Iterator mock = Mockito.mock(Iterator.class);
        when(mock.next()).thenReturn("io1").thenReturn("io2");
        String res = mock.next() + "-" + mock.next();
        Assert.assertEquals("操作失败", "io1-io2", res);
    }

    /**
     * 根据参数class类型mock
     */
    @Test
    @SuppressWarnings("unchecked")
    public void mockitoTest4() {
        Comparable mock = Mockito.mock(Comparable.class);
        when(mock.compareTo(isA(User.class))).thenReturn(1);
        Assert.assertEquals("操作失败", 1, mock.compareTo(new User()));
    }

    /**
     * 根据返回值抛出异常
     */
    @Test
    public void mockitoTest5() {
        Properties mock = Mockito.mock(Properties.class);
        when(mock.get("ios")).thenThrow(new IllegalArgumentException("参数类型错误"));
        mock.get("ios");
        Assert.fail("ios 参数类型错误");
    }

    /**
     * 使用spy包装真实的对象
     * doReturn
     */
    @Test
    public void mockitoTest6() {
        Properties properties = new Properties();
        Properties spy = spy(properties);
        doReturn("42").when(spy).get("shoeSize");
        String shoeSize = (String) spy.get("shoeSize");
        Assert.assertEquals("42", shoeSize);
    }

    @Test
    public void mockitoTest7() {
        UserServiceImpl userService = new UserServiceImpl();

        LoginService spy = Mockito.spy(LoginService.class);
        boolean login1 = spy.login("admin123", "admin");
        boolean login2 = spy.login("admin12", "admin");
        System.out.printf("login1:%s--login2:%s\n", login1, login2);

        when(spy.login("admin123", "admin")).thenReturn(true);
        ReflectionTestUtils.setField(userService, "loginService", spy);
        boolean add = userService.add("admin", "admin123");
        Assert.assertTrue("操作失败", add);

//error        Boolean verify = Mockito.verify(spy).login("admin123", "a");
//        System.out.printf("verify:%s",verify);
    }


    /**
     * spy包装真实的对象,默认调用会调用真是对象的方法,执行真实的业务逻辑
     */
    @Test
    public void mockitoTest8() {
        LoginServiceImpl loginService = new LoginServiceImpl();
        //包装真实对象
        LoginServiceImpl spy = spy(loginService);
        //会调用真实对象的方法,执行真实的业务逻辑
        boolean login = spy.login("admin123", "admin");
        Assert.assertTrue("登录失败", login);
    }

    /**
     * spy包装实际对象
     */
    @Test
    public void mockitoTest9() {
        LoginServiceImpl loginService = new LoginServiceImpl();
        LoginServiceImpl spy = spy(loginService);
        doReturn(true).when(spy).login("admin", "admin");
        Assert.assertTrue("登录失败", spy.login("admin", "admin"));
    }

    /**
     * 验证方法的调用次数
     */
    @Test
    public void mockitoTest10() {
        LoginServiceImpl mock = Mockito.mock(LoginServiceImpl.class);
        when(mock.login(anyString(), anyString())).thenReturn(true);

        mock.login("admin123", "admin");
        //执行并验证参数
        verify(mock).login(ArgumentMatchers.matches("admin123"), ArgumentMatchers.matches("admin"));

        mock.add("2 times");
        mock.add("2 times");
        //调用2次
        verify(mock, times(2)).add("2 times");

        mock.add("at least 2 times");
        mock.add("at least 2 times");
        verify(mock, atLeast(2)).add("at least 2 times");

        mock.add("at least once");
        verify(mock, atLeastOnce()).add("at least once");

        mock.add("at most 3 times");
        mock.add("at most 3 times");
        mock.add("at most 3 times");
        verify(mock, atMost(3)).add("at most 3 times");

        verifyNoMoreInteractions(mock);
    }


    /**
     * InjectMocks 通过ArticleManager的构造函数注入 User && ArticleDataBase对象
     */
    @Mock
    User user;
    @Mock
    ArticleDataBase dataBase;
    @InjectMocks
    ArticleManager articleManager;

    @Test
    public void mockitoTest11() {
        articleManager.initialize("username1");
        verify(dataBase).add("username1");
    }

    @Captor
    public ArgumentCaptor<List<String>> captor;
    @Rule
    public MockitoRule rule1 = MockitoJUnit.rule();

    @SuppressWarnings("unchecked")
    @Test
    public void mockitoTest12() {
        List<String> list = Arrays.asList("someElement_test", "someElement");
        List<String> mock = mock(List.class);
        mock.addAll(list);
        verify(mock).addAll(captor.capture());
        List<String> value = captor.getValue();
//        System.out.println(value.contains("someElement"));
    }

    @Test
    public void mockitoTest13() {
        List mock = mock(List.class);
        doAnswer(returnsFirstArg()).when(mock).add(anyString());

        when(mock.add(anyString())).thenAnswer(returnsFirstArg());

        when(mock.add(anyString())).then(returnsFirstArg());

        mock.add("测试");
    }

    /**
     * 回调
     */
    @Test
    public void mockitoTest14(){
        LoginService mock = mock(LoginService.class);
        when(mock.add("测试")).thenAnswer(name-> 0);
    }
}
