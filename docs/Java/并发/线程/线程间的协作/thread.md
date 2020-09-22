# 线程间的协作 - `java.lang.Thread` 相关

### `Thread#sleep()`



### `Thread#join()`

**在当前线程中调用另一个线程的 join() 方法，会将当前线程被挂起进入等待状态（Waiting），而不是忙等待，直到目标线程结束。**

#### 示例
对于以下代码，虽然 b 线程先启动，但是因为在 b 线程中调用了 a 线程的 join() 方法，b 线程会等待 a 线程结束才继续执行，因此最后能够保证 a 线程的输出先于 b 线程的输出。

```java
public class JoinExample {
    private class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B extends Thread {
        private A a;
        B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test() {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }
}

public static void main(String[] args) {
    JoinExample example = new JoinExample();
    example.test();
}


// output
A
B
```

#### 改进
J.U.C 类库中的 `CyclicBarrier` 可能比最初的线程类库中的 `join()` 方法更加好用。


### `Thread#yield()`

- 让出当前线程的 CPU 时间片（但不一定会让出，取决于线程调度器），重新进入就绪状态，竞争 CPU 的调度。
- 不会释放持有的锁