package designer.usafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author ： fjl
 * @date ： 2018/12/18/018 10:10
 */
public class CasCounter implements Runnable {

    private int counter = 0;
    private static final int SIZE = 10000;
    private Unsafe unsafe;
    private long offset;

    CasCounter() throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        unsafe = (Unsafe) theUnsafe.get(null);
        offset = unsafe.objectFieldOffset(CasCounter.class.getDeclaredField("counter"));
    }

    @Override
    public void run() {
        for (int i = 0; i < SIZE; i++) {
            int expect = counter;
            while (!unsafe.compareAndSwapInt(this, offset, expect, expect + 1)) {
                expect = counter;
            }
        }
        System.out.printf("Thread-id:%d--counter:%d\n", Thread.currentThread().getId(), counter);
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        CasCounter casCounter = new CasCounter();
        for (int i = 0; i < 10; i++) {
            new Thread(casCounter).start();
        }
    }
}
