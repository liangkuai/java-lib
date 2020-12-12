# Object 类

> `java.lang.Object`
>
> 所有类的父类。

```java
public class Object {
    
    /**
     * 返回当前对象对应的 Class 对象
     */
    public final native Class<?> getClass();

    /**
     * 用于创建并返回当前对象的一份拷贝
     */
    protected native Object clone() throws CloneNotSupportedException;

    public native int hashCode();

    public boolean equals(Object obj) {...}

    public String toString() {...}

    public final native void notify();

    public final native void notifyAll();

    public final native void wait(long timeout) throws InterruptedException;

    public final void wait(long timeout, int nanos) throws InterruptedException {...}

    public final void wait() throws InterruptedException {...}

    protected void finalize() throws Throwable { }
}
```

#### 1. equals() 和 hashCode()
参考：[equals() 和 hashCode()](/docs/Java/基础/equals()和hashCode().md)

#### 2. wait / notify / notifyAll
参考：[wait / notify / notifyAll](/docs/Java/并发/线程/线程间的协作/object.md)