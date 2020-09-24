# JVM 参数

### 内存相关

#### 堆
```
-Xms        // 堆初始大小
-Xmx        // 堆最大大小
```

#### 新生代
```
-Xmn                // 新生代大小
-XX:NewSize         // 新生代初始大小
-XX:MaxNewSize      // 新生最大大小
```

> 因为 Full GC 的成员远高于 Minor GC，所以尽可能将对象分配在新生代。实际项目中应该根据 GC 日志分析新生代空间大小分配是否合理，适当调节新生代大小，最大限度降低新对象直接进入老年代的情况。

```
-XX:NewRatio        //设置新生代和老年代的比值
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