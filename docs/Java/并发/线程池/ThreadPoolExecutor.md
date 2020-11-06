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


### 原理分析

```java
    // 存放线程池的运行状态（runState）和线程池内有效线程的数量（workerCount）
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    // 任务队列
    private final BlockingQueue<Runnable> workQueue;

    public void execute(Runnable command) {
        // 如果任务为 null，则抛出异常
        if (command == null)
            throw new NullPointerException();

        // ctl 中保存的线程池当前的一些状态信息
        int c = ctl.get();

        // 1. 先判断当前线程池中运行的任务数量是否小于 corePoolSize
        // 如果小于的话，通过 addWorker(command, true) 新建一个线程，并将任务（command）添加到该线程中；
        // 然后，启动该线程从而执行任务。
        if (workerCountOf(c) < corePoolSize) {
            if (addWorker(command, true))
                return;
            c = ctl.get();
        }
        // 2. 如果当前运行的任务数量大于等于 corePoolSize
        // 通过 isRunning() 方法判断线程池状态，线程池处于 RUNNING 状态并且队列可以加入任务，该任务才会被加入进去。
        if (isRunning(c) && workQueue.offer(command)) {
            int recheck = ctl.get();
            // 再次获取线程池状态，如果线程池状态不是 RUNNING 状态就需要从任务队列中移除任务，并尝试判断线程是否全部执行完毕；
            // 同时执行拒绝策略。
            if (! isRunning(recheck) && remove(command))
                reject(command);
            else if (workerCountOf(recheck) == 0)   // 如果当前线程池为空就新创建一个线程并执行
                addWorker(null, false);
        }
        // 3. 通过 addWorker(command, false) 新建一个线程，并将任务（command）添加到该线程中；然后，启动该线程从而执行任务。
        // 如果 addWorker(command, false) 执行失败，则通过 reject() 执行相应的拒绝策略的内容。
        else if (!addWorker(command, false))
            reject(command);
    }
```


### 对比

#### `execute()` 和 `submit()`
- `execute()` 方法用于提交不需要返回值的任务，所以无法判断任务是否被线程池执行成功与否；
- `submit()` 方法用于提交需要返回值的任务。线程池会返回一个 `Future` 类型的对象，通过这个 `Future` 对象可以判断任务是否执行成功，并且可以通过 `Future` 的 `get()` 方法来获取返回值，`get()` 方法会阻塞当前线程直到任务完成，而使用 `get(long timeout，TimeUnit unit)`方法则会阻塞当前线程一段时间后立即返回，这时候有可能任务没有执行完。

#### `shutdown()` 和 `shutdownNow()`
- `shutdown()` ：关闭线程池，线程池的状态变为 `SHUTDOWN`。线程池不再接受新任务了，但是队列里的任务得执行完毕。
- `shutdownNow()` ：关闭线程池，线程的状态变为 `STOP`。线程池会终止当前正在运行的任务，并停止处理排队的任务并返回正在等待执行的 List。

#### `isTerminated()` 和 `isShutdown()`
- `isShutDown()` ：当调用 `shutdown()` 方法后返回为 true。
- `isTerminated()` ：当调用 `shutdown()` 方法后，并且所有提交的任务完成后返回为 true。