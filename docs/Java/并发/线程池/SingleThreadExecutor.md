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

1. 当线程池内正在运行的线程数 = 0 时，就创建一个新的线程执行新任务。
2. 当线程池内有一个正在运行的线程时，如果再来新任务，就把任务加入 `LinkedBlockingQueue`。
3. 线程执行完当前的任务之后，会在循环中反复从 `LinkedBlockingQueue` 中取任务来执行。


#### 3. 为什么不推荐使用 `SingleThreadExecutor` ？
`SingleThreadExecutor` 使用无界队列 `LinkedBlockingQueue` 作为线程池的任务队列（队列的容量为 `Intger.MAX_VALUE`），对线程池带来的影响与 `FixedThreadPool` 相同。


### 参考

- 《Java 并发编程的艺术》
