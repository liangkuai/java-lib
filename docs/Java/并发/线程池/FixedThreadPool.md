# FixedThreadPool

`FixedThreadPool` 被称为可重用固定线程数的线程池。

#### 1. 创建方式
工具类 `Executors` 中提供静态方法用来创建 `FixedThreadPool` 实例：

```java
    /**
     * 创建一个可重用固定数量线程的线程池
     */
    public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>(),
                                      threadFactory);
    }

    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }
```

- `corePoolSize` 和 `maximumPoolSize` 都被设置为 nThreads，并且这个 nThreads 参数是创建的时候传递的。


#### 2. 任务执行过程
`FixedThreadPool` 的 `execute()` 方法运行示意图：

![FixedThreadPool](/assets/images/Java/thread-pool/FixedThreadPool.jpeg)

1. 当线程池内正在运行的线程数 < `corePoolSize` 时，如果再来新任务，就创建新的线程来执行。
2. 当线程池内正在运行的线程数 = `corePoolSize` 时，如果再来新任务，就把任务加入 `LinkedBlockingQueue`。
3. 线程池内的线程执行完当前任务之后，会在循环中反复从 `LinkedBlockingQueue` 中取任务来执行。


#### 3. 为什么不推荐使用 `FixedThreadPool` ？
`FixedThreadPool` 使用无界队列 `LinkedBlockingQueue`（队列的容量为 `Intger.MAX_VALUE`）作为线程池的任务队列会对线程池带来如下影响 ：

1. 当线程池内的线程数达到 `corePoolSize` 后，新任务将在无界队列中等待，因此线程池中的线程数不会超过 `corePoolSize`。
2. **由于使用无界队列时 `maximumPoolSize` 将是一个无效参数**，因为几乎不存在任务队列满的情况。所以，通过创建 `FixedThreadPool` 的源码可以看出创建的 `FixedThreadPool` 的 `corePoolSize` 和 `maximumPoolSize` 被设置为同一个值。
3. 由于 1 和 2，使用无界队列时 `keepAliveTime` 将是一个无效参数；
4. 运行中的 `FixedThreadPool`（未执行 `shutdown()` 或 `shutdownNow()`）不会拒绝任务，在任务比较多的时候会导致 OOM（内存溢出）。


### 参考

- 《Java 并发编程的艺术》