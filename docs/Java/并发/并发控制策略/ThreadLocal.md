# ThreadLocal

线程本地变量

### 结构
`Thread` 类中有一个 `ThreadLocal.ThreadLocalMap` 类的实例变量，也就是说每个线程都有自己的 `ThreadLocalMap` 用来存储 `<ThreadLocal, value>` 变量。


### Hash 算法


### Hash 冲突


### 扩容


### FAQ

#### 1. `ThreadLocalMap` 的 key 为什么要设计为 `WeakReference` ？
`ThreadLocalMap` 的 key 是一个 `ThreadLocal` 对象，如果 key 是强引用，在这个 `ThreadLocal` 对象使用完后，把引用设置为 `null`，但是这个对象并不会被回收，因为线程内会保持 `ThreadLocalMap->entry->key` 的引用链，直到线程被销毁，但是这个线程很可能被放到线程池中不会被销毁，这样就产生了内存泄漏。

JDK 通过弱引用来解决这个问题，entry 对 key 使用弱引用，当 `ThreadLocal` 对象的没有被外部强引用后，下次 GC 就可以回收 key 了。

> 参考：[Java中的强引用，软引用，弱引用，虚引用有什么用？ - 吕清海的回答 - 知乎](https://www.zhihu.com/question/37401125/answer/337717256)

#### 2. `ThreadLocal` 内存泄漏问题
接着上一个问题，`ThreadLocalMap` 的 key 是 `WeakReference`，当 `ThreadLocal` 对象没有被外部强引用时，GC 会把这个 key 回收，但是 entry 的 value 是强引用，这样就导致了 `<null, value>` 的 entry。如果线程放到线程池复用，一直没有被销毁，那么 value 也不会被回收，有可能会导致内存泄漏。

**为了解决这个问题，在线程执行完之后需要调用 `remove()` 方法**。除此之外，`ThreadLocalMap` 实现中已经考虑了这种情况，在调用 `set()`、`get()`、`remove()` 方法的时候，会清理掉 key 为 `null` 的记录。


## `InheritableThreadLocal`

**在异步场景下，子线程无法继承父线程中的 `ThreadLocal` 变量**。为了解决这个问题，JDK 还提供了 `InheritableThreadLocal` 类。

#### 实现原理
子线程是在父线程中通过调用 `new Thread()` 方法来创建子线程，`Thread#init` 方法在 Thread 的构造方法中被调用。**在 `init()` 方法中拷贝父线程数据到子线程中**：
```java
private void init(ThreadGroup g, Runnable target, String name,
                  long stackSize, AccessControlContext acc,
                  boolean inheritThreadLocals) {
    ...

    if (inheritThreadLocals && parent.inheritableThreadLocals != null)
        this.inheritableThreadLocals =
            ThreadLocal.createInheritedMap(parent.inheritableThreadLocals);

    ...
}
```

#### 问题
`InheritableThreadLocal` 仍然有缺陷，一般我们做异步化处理都是使用的线程池，而 `InheritableThreadLocal` 是在 `new Thread()` 中的 `init()` 方法赋值的，而线程池是线程复用的逻辑，所以这里会存在问题。

阿里巴巴开源了一个 `TransmittableThreadLocal` 组件可以解决这个问题。