# AQS

> 前置知识
> - 自旋锁
> - LockSupport
> - ...

> `java.util.concurrent.locks.AbstractQueuedSynchronizer`
>
> 抽象的队列式的同步器。

AQS 是用来构建锁或者其他同步器组件的重量级基础框架，通过内置的 FIFO 队列来完成资源获取和线程的排队工作，并通过一个 `int` 类型的变量表示持有锁的状态。

使用 AQS 能简单且高效地构造出大量的同步器，后续会提到的 `ReentrantLock`、`Semaphore`、`CountDownLatch` 等等都是基于 AQS 实现的。


#### 成员变量：state
```java
private volatile int state;
```
AQS 中维护了一个变量 state 代表共享资源。

#### FIFO 队列
多线程争用资源被阻塞时，会进入此队列。
