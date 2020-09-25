# ThreadPoolExecutor

### 参数


#### coolPoolSize（核心线程数）



#### maximumPoolSize（最大线程数）



#### keepAliveTime（空闲线程的存活时间）

针对空闲的线程，如果空闲时间超过了 `keepAliveTime`，
- 当前线程池中的线程数 <= `coolPoolSize`，这个空闲的线程将被标记为可回收；
- 当前线程池中的线程数 > `coolPoolSize`，这个空闲的线程将被终止。


#### maximumPoolSize（最大线程数）



#### workQueue（任务队列）



#### handler（拒绝策略）