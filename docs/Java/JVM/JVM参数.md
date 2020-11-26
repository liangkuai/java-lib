# JVM 参数

### 内存相关
#### 堆
```
-Xms        // 堆初始大小
-Xmx        // 堆最大大小

-XX:+HeapDumpOnOutOfMemoryError     // 堆发生 OOM 时 dump 当前内存转储快照
```

#### 新生代
```
-Xmn                // 新生代大小
-XX:NewSize         // 新生代初始大小
-XX:MaxNewSize      // 新生最大大小
```

> 因为 Full GC 的成员远高于 Minor GC，所以尽可能将对象分配在新生代。实际项目中应该根据 GC 日志分析新生代空间大小分配是否合理，适当调节新生代大小，最大限度降低新对象直接进入老年代的情况。

```
-XX:NewRatio        // 设置新生代和老年代的比例

-XX:Survivor=8      // 设置 Eden 区和 Survivor 区的比例，默认 8
```


#### 永久代
```
-XX:PermSize        // 方法区 (永久代) 初始大小
-XX:MaxPermSize     // 方法区 (永久代) 最大大小
```

#### 元空间
```
-XX:MetaspaceSize       // Metaspace 初始大小
-XX:MaxMetaspaceSize    // Metaspace 最大大小
```


### GC 相关
#### 垃圾回收器
```
-XX:+UseSerialGC
-XX:+USeParNewGC
-XX:+UseParallelGC
-XX:+UseConcMarkSweepGC
-XX:+UseG1GC
```

#### GC
```
-verbose:gc                 // 输出 GC 详情
-XX:+PrintGCDetails         // 打印 GC 详情日志
-XX:+PrintGCDateStamps      // 打印 GC 日志时间戳
```


### 并发相关
#### 锁
```
-XX:+UseSpinning            // 开启自旋锁
-XX:PreBlockSpin=10         // 自适应自旋次数
-XX:+UseBiasedLocking       // 开启偏向锁
```