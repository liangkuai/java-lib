# CountDownLatch

维护了一个计数器 cnt，每次调用 `countDown()` 方法会让计数器的值减 1，减到 0 的时候，那些因为调用 `await()` 方法而在等待的线程就会被唤醒。

也被称为倒计时器。


```java
public class CountDownLatch {

    private final Sync sync;

    public CountDownLatch(int count) {
        if (count < 0) throw new IllegalArgumentException("count < 0");
        this.sync = new Sync(count);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    public void countDown() {
        sync.releaseShared(1);
    }

    public long getCount() {
        return sync.getCount();
    }

    ...
}
```

- 等待的线程调用 `await()` 方法；
- 被等待的线程执行完之后调用 `countDown()` 方法。


### 使用场景

#### 1. 一个线程等待 n 个线程执行完毕之后再开始执行
例如：启动一个服务时，主线程需要等待多个组件加载完毕，之后再继续执行。



### `CountDownLatch` 的不足

`CountDownLatch` 是一次性的，计数器的值只能在构造方法中初始化一次，之后没有任何机制再次对其设置值，当 `CountDownLatch` 使用完毕后，它不能再次被使用。