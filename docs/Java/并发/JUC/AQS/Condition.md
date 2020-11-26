# Condition

JDK 1.5 开始出现，用来替代传统的 `wait/notify` 线程协作机制。




```java
public interface Condition {

    void await() throws InterruptedException;

    void signal();

    void signalAll();
}
```