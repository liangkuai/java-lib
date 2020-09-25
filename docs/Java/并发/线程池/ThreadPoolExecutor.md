# ThreadPoolExecutor

### 参数

#### coolPoolSize（核心线程数）



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