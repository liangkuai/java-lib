# 问题

## 如何解决 OOM？

- 堆内存溢出


### 堆内存溢出
> java.lang.OutOfMemoryError: Java heap space

JVM 提供参数 `-XX:+HeapDumpOnOutOfMemoryError` 在发生 OOM 时 dump 当前内存转储快照，可以使用 Eclipse Memory Analyzer（MAT）分析。


### 元空间溢出
> java.lang.OutOfMemoryError: Metaspace


### 直接内存溢出



### 栈内存溢出





## 如何排查 CPU 100%？

#### 1. `top` 命令查询 CPU 使用率最高的进程

#### 2. 接着找出该进程下的线程

#### 3. `jstack` 工具导出进程快照
```bash
jstack -l {进程id} > /tmp/{进程id}.stack
```

#### 4. 找到对应线程的调用栈
```bash
cat {进程id}.stack | grep {16进制线程id} -C 10
```

