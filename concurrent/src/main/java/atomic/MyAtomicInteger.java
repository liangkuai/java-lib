package atomic;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liukai
 * @date 18-10-26
 */
public class MyAtomicInteger {

    /**
     * Unsafe 内部封装了 CAS 系列方法
     */
    private static final Unsafe unsafe = Unsafe.getUnsafe();

    /**
     * 成员变量 value 在内存中的偏移地址
     */
    private static final long valueOffset;

    static {
        try {
            // 使用 Unsafe 提供的 objectFieldOffset() 方法
            // 获取成员变量 value 在内存中的偏移地址
            valueOffset = unsafe.objectFieldOffset
                    (AtomicInteger.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }


    private int value;


    public MyAtomicInteger() {
    }


    /**
     * i++（原子操作）
     */
    public int getAndIncrement() {
        return unsafe.getAndAddInt(this, valueOffset, 1);
    }
}
