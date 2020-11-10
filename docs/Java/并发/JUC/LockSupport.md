# LockSupport

> `java.util.concurrent.locks.LockSupport`
>
> `LockSupport` 是用来创建锁和其他同步类的基本线程阻塞原语。

- `LockSupport` 内部都是静态方法


### 原理

`LockSupport` 类使用一种名为「许可证」（permit）的概念来实现阻塞和唤醒线程的功能。

每个线程都有一个 permit，**permit 只有 0 和 1 两种值（默认是 0）**，如果线程持有这个 permit（permit = 1），就可以继续运行，否则就会进入 `Waiting` 状态。


### 阻塞（park）

```java
public class LockSupport {
    private LockSupport() {} // Cannot be instantiated.

    /**
     * 阻塞当前线程
     */
    public static void park() {
        UNSAFE.park(false, 0L);
    }

    public static void park(Object blocker) {
        Thread t = Thread.currentThread();
        setBlocker(t, blocker);
        UNSAFE.park(false, 0L);
        setBlocker(t, null);
    }

    ...
}
```

#### 1. `park()`
- 因为每个线程默认不持有 permit（permit = 0），所以调用 `LockSupport.park()`，当前线程会进入 `Waiting` 状态。
- 只有以下情况，被 park 的线程才会被唤醒，
    1. **任何其他线程对该线程对象调用 `unpark(thread)` 方法，会提供 permit 来唤醒该线程，随后重置 permit = 0。（permit 最多为 1，多次调用 `unpark(thread)` 不会累加 permit）**
    2. 该线程调用的是具有超时时间的 `park()` 方法，超时后自动唤醒。
    3. 任何其他线程调用该线程的 `interrupt()`，中断线程。
    4. 由于硬件操作系统不可预知的原因，导致了虚假唤醒。

#### 2. `park(Object blocker)`
`blocker` 参数的作用是可以传入一个对象，记录一些监控信息；这样当线程被 park 进入 `Waiting` 状态时，我们可以调用 `getBlocker()` 方法读取这个对象，从而获取这个线程的一些情况。

注意这里获取的仅仅是最后一次 park 的对象信息，因为 `park()` 方法可以调用无数次，所以这里只能保证获取最新的自定义的对象监控信息。


### 唤醒（unpark）

```java
public class LockSupport {
    private LockSupport() {} // Cannot be instantiated.

    /**
     * 唤醒指定线程
     */
    public static void unpark(Thread thread) {
        if (thread != null)
            UNSAFE.unpark(thread);
    }

    ...
}
```

#### 1. `unpark(Thread thread)`
给参数 thread 线程提供一个 permit，
- 如果 thread 之前调用了 `park()`，那么调用 `unpark()` 之后，就会被唤醒；
- 如果 thread 之前没有调用过 `park()`，那么调用 `unpark()` 之后再调用 `park()` 会立刻返回，相当与没有执行过一样。


### 与 `wait/notify` 和 `await/signal` 的区别

`wait/notify` 和 `await/signal` 都有两个缺点，
- 都需要在同步代码块中调用；
- 线程 B 要调用 `notify()` 唤醒线程 A，那么要确保线程 A 已经调用过 `wait()` 进入等待状态，否则线程 A 可能永远都在等待。

`park/unpark` 模型真正解耦了线程之间的同步，线程之间不再需要一个 Object 或者其他变量来存储状态。