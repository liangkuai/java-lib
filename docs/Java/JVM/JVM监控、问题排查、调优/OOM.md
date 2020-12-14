# OOM


## 如何解决 OOM？

- 堆内存溢出


### 堆内存溢出
> java.lang.OutOfMemoryError: Java heap space

JVM 提供参数 `-XX:+HeapDumpOnOutOfMemoryError` 在发生 OOM 时 dump 当前内存转储快照，可以使用 Eclipse Memory Analyzer（MAT）分析。


### 元空间溢出
> java.lang.OutOfMemoryError: Metaspace


### 直接内存溢出



### 栈内存溢出