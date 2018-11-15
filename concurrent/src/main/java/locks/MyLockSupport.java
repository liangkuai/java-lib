package locks;

import sun.misc.Unsafe;

/**
 * @author liangkuai
 * @date 2018/11/12
 */
public class MyLockSupport {

    public MyLockSupport() {
    }

    public static Object getBlocker(Thread t) {
        if (t == null)
            throw new NullPointerException();
        return UNSAFE.getObjectVolatile(t, parkBlockerOffset);
    }

    private static void setBlocker(Thread t, Object arg) {
        UNSAFE.putObject(t, parkBlockerOffset, arg);
    }


    /**
     * 让当前线程进入 waiting 状态
     */
    public static void park() {
        UNSAFE.park(false, 0L);
    }

    /**
     * @since jdk 1.6
     */
    public static void park(Object blocker) {
        Thread t = Thread.currentThread();
        setBlocker(t, blocker);
        UNSAFE.park(false, 0L);
        setBlocker(t, null);
    }

    /**
     * 让当前线程进入 waiting 状态，nanos 纳秒时间
     */
    public static void parkNanos(long nanos) {
        if (nanos > 0)
            UNSAFE.park(false, nanos);
    }

    /**
     * @since jdk 1.6
     */
    public static void parkNanos(Object blocker, long nanos) {
        if (nanos > 0) {
            Thread t = Thread.currentThread();
            setBlocker(t, blocker);
            UNSAFE.park(false, nanos);
            setBlocker(t, null);
        }
    }


    /**
     * 唤醒线程
     */
    public static void unpark(Thread thread) {
        if (thread != null)
            UNSAFE.unpark(thread);
    }




    private static final Unsafe UNSAFE;


    /**
     * parkBlockerOffset 是 parkBlocker 字段对象在内存中相对于 Thread.class 这个类对象的起始地址的偏移量
     *
     * parkBlocker 是 Thread 对象中的成员变量，用于记录线程被谁阻塞的。
     */
    private static final long parkBlockerOffset;
    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();

            // 通过反射机制获取 Thread 类的 parkBlocker 字段对象
            //
            // 再通过 Unsafe 对象的 objectFieldOffset() 方法
            // 获取到 parkBlocker 字段对象在内存中相对于 Thread.class 这个类对象的起始地址的偏移量
            parkBlockerOffset = UNSAFE.objectFieldOffset(Thread.class.getDeclaredField("parkBlocker"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

}
