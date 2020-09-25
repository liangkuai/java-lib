# 线程池


### 类结构

- `Executor`（interface）
    - `ExecutorService`（interface）
        - `AbstractExecutorService`（abstract）
            - `ThreadPoolExecutor`（class）
        - `ScheduledExecutorService`（interface）
            - `ScheduledThreadPoolExecutor`（class）
- `Executors`（class）


#### `Executor`

线程池框架顶级接口，

- `Executor` 仅仅提供了一个 `execute()` 方法来执行已提交的 `Runnable` 任务。
- 目的是提供一种将「任务提交」与「任务运行」分离的机制。

#### `ExecutorService`

`ExecutorService` 继承自 `Executor`。