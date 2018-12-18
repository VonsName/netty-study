package designer.usafe;

import sun.misc.Unsafe;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ： fjl
 * @date ： 2018/11/16/016 8:35
 */
public class UnSafeTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException, IOException {

        Field u = Unsafe.class.getDeclaredField("theUnsafe");
        u.setAccessible(true);
        Unsafe unsafe = (Unsafe) u.get(null);
        User user = (User) unsafe.allocateInstance(User.class);
        user.setPassword("123");
        user.setUsername("lisi");
        System.out.println(user);
        Field declaredField = user.getClass().getDeclaredField("password");
        long l = unsafe.objectFieldOffset(declaredField);
        System.out.println(l);

//        long address = unsafe.getAddress(l);

//        System.out.printf("address:%d", address);

        String a = "中过啊";
        System.out.println(a.getBytes().length);

        byte[] bytes = getBytes();
//        Class<?> aClass = unsafe.defineClass(null, bytes, 0, bytes.length, UnSafeTest.class.getClassLoader(), new ProtectionDomain(new CodeSource()));
//        aClass.getDeclaredField("")
    }

    private static byte[] getBytes() throws IOException {
        File file = new File("D:\\myTest\\netty-study\\target\\classes\\designer\\User.class");
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        int read = fileInputStream.read(bytes);
        fileInputStream.close();
        return bytes;
    }
}
