# ThreadPoolExecutor

线程池的实现类 `ThreadPoolExecutor` 是 Executor 框架的核心。

以下是 `ThreadPoolExecutor` 的构造方法，
```java
/**
 * @param corePoolSize 线程池的核心线程数
 * @param maximumPoolSize 线程池的最大线程数
 * @param keepAliveTime 当线程数大于核心线程数时，多余的空闲线程存活的最长时间
 * @param unit 时间单位
 * @param workQueue 任务队列，用来储存等待执行的任务
 * @param threadFactory 线程工厂，用来创建线程，一般默认即可
 * @param handler 拒绝策略，当提交的任务过多而不能及时处理时，使用拒绝策略来处理新任务
 */
public ThreadPoolExecutor(int corePoolSize,
                          int maximumPoolSize,
                          long keepAliveTime,
                          TimeUnit unit,
                          BlockingQueue<Runnable> workQueue,
                          ThreadFactory threadFactory,
                          RejectedExecutionHandler handler) {
    if (corePoolSize < 0 ||
        maximumPoolSize <= 0 ||
        maximumPoolSize < corePoolSize ||
        keepAliveTime < 0)
        throw new IllegalArgumentException();
    if (workQueue == null || threadFactory == null || handler == null)
        throw new NullPointerException();
    this.acc = System.getSecurityManager() == null ?
            null :
            AccessController.getContext();
    this.corePoolSize = corePoolSize;
    this.maximumPoolSize = maximumPoolSize;
    this.workQueue = workQueue;
    this.keepAliveTime = unit.toNanos(keepAliveTime);
    this.threadFactory = threadFactory;
    this.handler = handler;
}
```

### 参数

#### coolPoolSize（核心线程数）
核心线程数线程数定义了最小可以同时运行的线程数量。

#### maximumPoolSize（最大线程数）
当任务队列中存放的任务达到队列容量的时候，当前可以运行的线程数量变为 `maximumPoolSize`。

#### keepAliveTime（空闲线程的存活时间）
当前线程池中的线程数大于 `corePoolSize` 时，非核心线程会空闲等待 `keepAliveTime`，如果期间没有新的任务提交，就会被销毁回收。

#### workQueue（任务队列）
当新任务来的时候会先判断当前正在运行的线程数量是否达到 `coolPoolSize`，如果达到的话，新的任务就会被存放在队列中。

#### handler（拒绝策略）
如果当前正在运行的线程数达到 `maximumPoolSize`，并且任务队列已满，线程池就会按照拒绝策略处理新的任务。

`ThreadPoolExecutor` 内置了 4 中拒绝策略（4 个静态内部类），

- `ThreadPoolExecutor.AbortPolicy` ：拒绝处理新任务，抛出 `RejectedExecutionException`。
- `ThreadPoolExecutor.DiscardPolicy` ：不处理新任务，直接丢弃。
- `ThreadPoolExecutor.CallerRunsPolicy` ：调用执行自己的线程运行新任务。
- `ThreadPoolExecutor.DiscardOldestPolicy` ：丢弃任务队列中最旧的未处理任务，然后将新任务添加到队列。

其中 `ThreadPoolExecutor.AbortPolicy` 是线程池默认的拒绝策略。

- 自定义：实现 `RejectedExecutionHandler` 接口，在使用 `ThreadPoolExecutor` 创建线程池时，将实现类的对象作为参数传递。