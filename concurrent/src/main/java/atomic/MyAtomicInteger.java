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

    /**
     * volatile 保证可见性
     */
    private volatile int value;


    public final int get() {
        return value;
    }

    public void set(int newValue) {
        value = newValue;
    }


    public MyAtomicInteger() {
    }

    public MyAtomicInteger(int initialValue) {
        value = initialValue;
    }


    public final int getAndSet(int newValue) {
        return unsafe.getAndSetInt(this, valueOffset, newValue);
    }


    /**
     * CAS
     *
     * @param expect 预期值
     * @param update 更新值
     *
     * @return 是否修改成功
     */
    public final boolean compareAndSet(int expect, int update) {
        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }


    /**
     * i++
     */
    public int getAndIncrement() {
        return unsafe.getAndAddInt(this, valueOffset, 1);
    }

    /**
     * i--
     */
    public int getAndDecrement() {
        return unsafe.getAndAddInt(this, valueOffset, -1);
    }

    /**
     * ++i
     */
    public int incrementAndGet() {
        return unsafe.getAndAddInt(this, valueOffset, 1) + 1;
    }

    /**
     * --i
     */
    public final int decrementAndGet() {
        return unsafe.getAndAddInt(this, valueOffset, -1) - 1;
    }


    /**
     * n++
     */
    public final int getAndAdd(int delta) {
        return unsafe.getAndAddInt(this, valueOffset, delta);
    }

    /**
     * ++n
     */
    public final int addAndGet(int delta) {
        return unsafe.getAndAddInt(this, valueOffset, delta) + delta;
    }
}
