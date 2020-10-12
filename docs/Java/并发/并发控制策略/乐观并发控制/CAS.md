# CAS

> CAS 是一种乐观并发控制策略。

### 语义

Compare And Swap，比较与交换。

**该操作通过将内存中的值与新值进行比较，当数值一样时将内存中的数据替换为新值。**

也就是说，在并发环境下，我们想要把内存地址 addr 的数据改成 new，并且在进入 CAS 操作前，我们先获取到内存地址 addr 的数据是 old。利用 CAS 操作：
1. 如果当前内存地址 addr 的数据还是 old，就更新为 new；
2. 如果不是，就不进行操作，不会更新内存的数据。

> **CAS 是原子操作。**


### 实现

在 Java 中，`sum.misc.Unsafe` 类提供 compareAndSwap 系列函数封装了 CAS 操作。

如下，对于 int 值的 CAS 操作：

```java
/**
 * @param o 进行 CAS 操作的对象
 * @param offset 成员变量的值在内存中相对于对象 o 的偏移地址
 * @param expect 期望的值
 * @param update 更新后的值
 */
public final native boolean compareAndSwapInt(Object o, long offset, int expect, int update);
```


### 问题

1. ABA 问题

    在进行 CAS 操作前，其他线程将值 A 改为 B，然后又改回 A。这种情况下，CAS 操作无法发现值的变化。