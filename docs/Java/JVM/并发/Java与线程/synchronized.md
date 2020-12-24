# synchronized 关键字

`synchronized` 关键字 Java 中最基本的**互斥同步方式**，保证被它修饰的方法或者代码块在任意时刻只能被一个线程执行。


### 使用

1. 修饰实例方法 ：对当前实例对象 this 加锁
2. 修饰代码块 ：对指定对象加锁
3. 修饰类方法 ：对当前类方法所属的 Class 对象加锁


### 原理

#### 1. Monitor（对象监视器）

在学习 `synchronized` 关键字的原理前，先了解一下与其关联密切的 Monitor（对象监视器）。

> 在 HotSpot VM 中，Monitor 是基于 C++ 实现的，由 `ObjectMonitor` 实现的。**每个对象中都内置了一个 `ObjectMonitor` 对象。**
>
> Monitor 内部有几个字段：
> - `_EntryList` ：队列， 存储等待获取锁（block 状态）的线程
> - `_WaitSet` ：队列，存储 wait 状态的线程
> - `_owner` ：指向持有 Monitor 对象的线程
> - `_count` ：同一线程的重入次数

每个对象都会与一个 monitor 关联，其实这个 monitor 就是一个互斥锁。

#### 2. synchronized 修饰代码块

用 `synchronized` 修饰代码块，通过对 class 文件反编译，可以发现在同步代码块前后有两个字节码指令 `monitorenter` 和 `monitorexit`。

- **这两个字节码指令都需要指定一个对象作为「同步对象」。**

- 在执行 `monitorenter` 指令时，当前线程会尝试获取「同步对象」关联的 monitor 的所有权。
    - 如果 monitor 的重入次数为 0，那么当前线程成为 monitor 的所有者；
    - 如果当前线程已经占有该 monitor，说明是重入，monitor 的重入次数 +1；
    - 如果其他线程已经占有该 monitor，当前线程进入阻塞状态，直到 monitor 的重入次数为 0，再重新尝试获取 monitor 的所有权。

- 在执行 `monitorexit` 指令时，当前线程必须是「同步对象」关联的 monitor 的所有者。
    - monitor 的重入次数 -1；
    - 如果重入次数为 0，线程退出 monitor，释放所有权。

#### 3. synchronized 修饰方法

用 `synchronized` 修饰方法，不是通过字节码 `monitorenter` 和 `monitorexit` 实现的，而是通过 `ACC_SYNCHRONIZED` 访问标志来辨别一个方法是否声明为同步方法。

当方法调用时，调用指令会检查方法的 `ACC_SYNCHRONIZED` 访问标志是否被设置，如果设置了，执行线程先获取 monitor，获取成功之后才能执行方法体；方法执行完后再释放 monitor。在方法执行期间，其他任何线程都无法再获得同一个 monitor 对象。

**其实本质上也是争夺 monitor，只是方法的同步是一种隐式的方式来实现，无需通过字节码来完成。**



#### 4. FAQ

> 1. `synchronized` 代码块中抛出异常，会不会释放锁？

会，通过反编译 class 文件，可以看到 `synchronized` 代码块后面有两条 `monitorexit` 指令。
- 如果正常，就会执行第一条 `monitorexit` 指令后面的 `goto` 指令；
- 如果抛出异常，会先执行 `goto` 指令之后的指令释放锁，再抛出异常。