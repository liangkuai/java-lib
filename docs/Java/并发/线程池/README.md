# 线程池

线程过多会带来额外的开销，其中包括创建销毁线程的开销、调度线程的开销等等，同时也降低了计算机的整体性能。

线程池是一种基于池化思想管理线程的工具。线程池维护多个线程，一方面避免了处理任务时创建销毁线程开销的代价，另一方面避免了线程数量膨胀导致的过分调度问题，保证了对内核的充分利用。

### 使用线程池的好处
- 降低资源消耗：通过池化技术重复利用已创建的线程，降低线程创建和销毁造成的损耗。
- 提高响应速度。任务到达时，不需要等待线程创建就能立即执行。
- 提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会因为线程的不合理分布导致资源调度失衡，降低系统的稳定性，使用线程池可以进行统一的分配、调优和监控。
- 提供更多更强大的功能：线程池具备可拓展性，允许开发人员向其中增加更多的功能。比如延时定时线程池 `ScheduledThreadPoolExecutor`，就允许任务延期执行或定期执行。


## Executor 框架

Executor 框架是 JDK 1.5 开始引进的，通过 Executor 来启动线程比使用 Thread 的 start 方法更好，除了更易管理，效率更好（用线程池实现，节约开销）外，还有关键的一点：有助于避免 this 逃逸问题。

> 「this 逃逸」是指在构造函数返回之前其他线程就持有该对象的引用. 调用尚未构造完全的对象的方法可能引发令人疑惑的错误。

Executor 框架不仅包括了线程池的管理，还提供了线程工厂、队列以及拒绝策略等，让并发编程变得更加简单。

### 1. 任务
- `Runnable`（interface）
- `Callable`（interface）

实现 `Runnable` 接口或 `Callable` 接口的类都表示任务，都可以通过 `ThreadPoolExecutor` 或 `ScheduledThreadPoolExecutor` 执行。

### 2. 任务的执行
Executor 框架的核心，类结构如下，
- `Executor`（interface）
    - `ExecutorService`（interface）
        - `AbstractExecutorService`（abstract）
            - `ThreadPoolExecutor`（class）
        - `ScheduledExecutorService`（interface）
            - `ScheduledThreadPoolExecutor`（class）
- `Executors`（class）

![线程池类结构](/assets/images/Java/thread-pool/线程池类结构.png)

#### `Executor`
线程池框架顶级接口，
- `Executor` 仅仅提供了一个 `execute()` 方法来执行已提交的 `Runnable` 任务。
- 目的是提供一种将「任务提交」与「任务运行」分离的机制。

#### `ExecutorService`
`ExecutorService` 继承自 `Executor`。

#### `ThreadPoolExecutor` 和 `ScheduledThreadPoolExecutor`
两个关键的线程池类都实现了 `ExecutorService` 接口，而且 `ScheduledThreadPoolExecutor` 实际上还继承了 `ThreadPoolExecutor` 类。

### 3. 任务的结果
- `Future`（interface）
- `FutureTask`（class）

`Future` 接口以及实现类 `FutureTask` 类都可以代表异步计算的结果。

`ThreadPoolExecutor` 或 `ScheduledThreadPoolExecutor` 调用 `submit()` 方法时就会返回一个 `Future` 实例。


---
### Executor 框架的使用

1. 创建任务，实现 `Runnable` 或 `Callable` 接口。
2. 提交给 `ExecutorService` 执行，`ExecutorService.execute()` 或 `ExecutorService.submit()`。
3. `ExecutorService.submit()` 会返回一个 `Future` 实例。


### 参考
- [Java线程池实现原理及其在美团业务中的实践](https://tech.meituan.com/2020/04/02/java-pooling-pratice-in-meituan.html)