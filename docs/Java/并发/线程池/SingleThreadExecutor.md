# SingleThreadExecutor

`SingleThreadExecutor` 是只有一个线程的线程池。

#### 1. 创建方式

工具类 `Executors` 中提供静态方法用来创建 `SingleThreadExecutor` 实例：

```java
    /**
     * 返回只有一个线程的线程池
     */
    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>(),
                                    threadFactory));
    }

    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()));
    }
```

- `SingleThreadExecutor` 的 `corePoolSize` 和 `maximumPoolSize` 都被设置为 1。


#### 2. 任务执行过程

`SingleThreadExecutor` 的 `execute()` 方法运行示意图：

![SingleThreadExecutor](/assets/images/Java/thread-pool/SingleThreadExecutor.jpeg)

1. 如果当前运行的线程数 = 0，就创建一个新的线程执行任务。
2. 当前线程池中有一个运行的线程后，将后续任务加入 `LinkedBlockingQueue`。
3. 线程执行完当前的任务后，会在循环中反复从 `LinkedBlockingQueue` 中获取任务来执行。


#### 3. 为什么不推荐使用 `SingleThreadExecutor` ？

`SingleThreadExecutor` 使用无界队列 `LinkedBlockingQueue` 作为线程池的任务队列（队列的容量为 `Intger.MAX_VALUE`）。对线程池带来的影响与 `FixedThreadPool` 相同。


### 参考

- 《Java 并发编程的艺术》
