package designer.usafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ： fjl
 * @date ： 2018/11/16/016 8:35
 */
public class UnSafeTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {

        Field u = Unsafe.class.getDeclaredField("theUnsafe");
        u.setAccessible(true);
        Unsafe unsafe = (Unsafe) u.get(null);
        User user = (User) unsafe.allocateInstance(User.class);
        user.setPassword("123");
        user.setUsername("lisi");
        System.out.println(user);
    }
}
