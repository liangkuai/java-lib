# Atomic 原子类

Atomic 原子类都是具有原子操作特征的类。Java 中的原子类都在 `java.util.concurrent.atomic` 包下。


### 实现

- 利用 CAS  + `volatile` 保证原子操作，从而避免 `synchronized` 的高开销，执行效率大为提升。
- 自旋（循环），作为 CAS 失败的补偿操作，保证更新操作持续直到完成。

以 `AtomicInteger` 类为例：

```java
/**
 * 原子操作：i++
 */
public final int getAndIncrement() {
    return unsafe.getAndAddInt(this, valueOffset, 1);
}

/**
 * 并发环境下，在进行 CAS 前，value 可能被修改，导致 CAS 失败；
 * 再通过自旋保证 +1 操作成功。
 */
public final int getAndAddInt(Object var1, long var2, int var4) {
    int var5;
    do {
        var5 = this.getIntVolatile(var1, var2);
    } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
    return var5;
}

/**
 * CAS
 */
public final native boolean compareAndSwapInt(Object var1, long var2, int var4, int var5);
```

### 问题

#### 1. ABA 问题
在进行 CAS 操作前，其他线程将值 A 改为 B，然后又改回 A。这种情况下，CAS 操作无法发现值的变化。

##### 解决
目前在 JDK 的 atomic 包里提供了一个类 `AtomicStampedReference` 来解决 ABA 问题。这个类的 compareAndSwap 方法作用是首先检查当前引用是否等于预期引用，并且当前标志是否等于预期标志，如果全部相等，则以原子方式将该引用和该标志的值设置为给定的更新值。

> 不过目前来说 `AtomicStampedReference` 比较 “鸡肋”，大部分情况下 ABA 问题不会影响程序并发的正确性，如果需要解决 ABA 问题，改用传统的互斥同步可能会比原子类更高效。

#### 2. 循环时间长开销大
如果 CAS 操作不成功，则会进行自旋，自旋就是循环，依然会需要 CPU 调度执行，如果长时间自旋会给 CPU 带来不少的执行开销。