# CachedThreadPool

`CachedThreadPool` 是一个会根据需要创建新线程的线程池。

#### 1. 创建方式
工具类 `Executors` 中提供静态方法用来创建 `CachedThreadPool` 实例：

```java
    /**
     * 创建一个根据需要创建新线程的线程池。
     */
    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>(),
                                      threadFactory);
    }

    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }
```

- `corePoolSize` 大小被设置为 0。
- `maximumPoolSize` 被设置为 `Integer.MAX.VALUE`，也就是没有限制。**这也就意味着如果主线程提交任务的速度高于线程池中线程处理任务的速度时，线程池会不断创建新的线程。极端情况下，这样会导致耗尽 CPU 和内存资源。**


#### 2. 任务执行过程
`CachedThreadPool` 的 `execute()` 方法的执行示意图：

![CachedThreadPool](/assets/images/Java/thread-pool/CachedThreadPool.jpeg)

1. 首先执行 `SynchronousQueue.offer(Runnable task)` 提交任务到任务队列；
1. 当线程池内没有空闲线程时，就创建新的线程执行任务；
2. 当线程池内有空闲线程正在执行 `SynchronousQueue.poll(keepAliveTime,TimeUnit.NANOSECONDS)`，那么主线程执行 `offer` 操作与空闲线程执行的 `poll` 操作配对成功，任务交给空闲线程执行。


#### 3. 为什么不推荐使用 `CachedThreadPool` ？
`CachedThreadPool` 允许创建的线程数量为 `Integer.MAX_VALUE`，可能会创建大量线程，导致 OOM。


### 参考

- 《Java 并发编程的艺术》
