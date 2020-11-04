# 线程池

池化技术屡见不鲜，线程池、数据库连接池等等。主要目的是提高资源利用率，减少每次获取资源的消耗。

### 使用线程池的好处
- 降低资源消耗。重复利用已创建的线程降低线程创建和销毁带来的消耗。
- 提高响应速度。当任务到达时，不需要等到线程创建就能立即执行。
- 提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。


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