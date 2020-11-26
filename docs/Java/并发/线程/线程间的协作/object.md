# 线程间的协作 - `java.lang.Object` 相关
- wait
- notify
- notifyAll

## wait

挂起线程

#### `wait()` 和 `sleep()` 的区别
- 两者最主要的区别在于：`wait()` 方法释放了锁，而 `sleep()` 方法没有释放锁；
- 两者都可以暂停线程的执行，即挂起线程；
- `wait()` 通常被用于线程间交互/通信，`sleep()` 通常被用于暂停执行；
- `wait()` 方法被调用后，线程不会自动唤醒，需要别的线程调用同一个对象上的 `notify()` 或者 `notifyAll()` 方法。`sleep()` 方法执行完成后，线程会自动唤醒，或者可以使用 `wait(long timeout)` 超时后线程会自动唤醒。


## notify

唤醒线程

## notifyAll



### 改进

J.U.C 类库中提供了 `Condition` 类来实现线程之间的协调，可以在 `Condition` 上调用 `await()` 方法使线程等待，其它线程调用 `signal()` 或 `signalAll()` 方法唤醒等待的线程。

相比于 `wait()` 这种等待方式，`await()` 可以指定等待的条件，因此更加灵活。