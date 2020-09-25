# 线程池

### 池化技术

池化技术屡见不鲜，线程池、数据库连接池等等。主要目的是提高资源利用率，减少每次获取资源的消耗。


### 类结构

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