# CyclicBarrier

字面意思：可循环使用的屏障。让一组线程在一个屏障（同步点）被阻塞，直到最后一个线程到达屏障，屏障才会打开，所有被屏障拦截的线程会被唤醒继续运行。



```java
public class CyclicBarrier {

    private int count;

    public CyclicBarrier(int parties, Runnable barrierAction) {
        if (parties <= 0) throw new IllegalArgumentException();
        this.parties = parties;
        this.count = parties;
        this.barrierCommand = barrierAction;
    }

    public CyclicBarrier(int parties) {
        this(parties, null);
    }

    public int await() throws InterruptedException, BrokenBarrierException {
        try {
            return dowait(false, 0L);
        } catch (TimeoutException toe) {
            throw new Error(toe); // cannot happen
        }
    }


}
```

- 到达屏障的线程调用 `await()`。


### `CountDownLatch` 和 `CyclicBarrier` 的区别

- `CountDownLatch`
    - 只能使用一次；
    - 一个或者多个线程，等待其他多个线程完成某件事情之后才能执行；

- `CyclicBarrier` 
    - 提供 reset 功能，可以多次使用；
    - 多个线程互相等待，直到到达同一个同步点，再继续一起执行。