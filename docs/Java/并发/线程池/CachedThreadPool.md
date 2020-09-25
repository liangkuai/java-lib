# CachedThreadPool

`CachedThreadPool` 是一个会根据需要创建新线程的线程池。

#### 1. 创建方式

`Executors` 类中提供静态方法用来创建 `CachedThreadPool` 实例：

```java
    /**
     * 创建一个线程池，根据需要创建新线程，但会在先前构建的线程可用时重用它。
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


#### 3. 为什么不推荐使用 `CachedThreadPool` ？

`CachedThreadPool` 允许创建的线程数量为 `Integer.MAX_VALUE`，可能会创建大量线程，导致 OOM。