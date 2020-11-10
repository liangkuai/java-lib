# Semaphore

信号量。

在并发编程中，有时我们关注的是互斥资源的数量，有空闲的资源我就取用，没有的话就阻塞。所以可以把一个 `Semaphore` 对象想象成一个内部维护了一组互斥资源的池，简单的用数字代表了资源的数量。反过来，`Semaphore` 也可以用来控制对互斥资源的访问的线程数量。


```java
public class Semaphore implements java.io.Serializable {

    private final Sync sync;

    public Semaphore(int permits) {
        sync = new NonfairSync(permits);
    }

    public Semaphore(int permits, boolean fair) {
        sync = fair ? new FairSync(permits) : new NonfairSync(permits);
    }

    public void acquire() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    public void release() {
        sync.releaseShared(1);
    }

    ...
}
```

- 调用 `acquire()` 获取许可；
- 调用 `release()` 释放许可。



### 模式

`Semaphore` 有两种模式，
- 公平模式 ：调用 acquire 的顺序就是获取许可证的顺序，遵循 FIFO；
- 非公平模式（默认） ：抢占式。