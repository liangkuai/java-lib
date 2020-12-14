# JVM 工具

- `jps` ：虚拟机进程状况工具
- `jinfo` ：Java 配置信息工具
- `jmap` ：Java 内存映像工具
- `jhat` ：虚拟机堆转储快照分析工具
- `jstack` ：Java 堆栈跟踪工具

## jps
虚拟机进程状况工具，jps（JVM Process Status Tool）。列出正在运行的虚拟机进程，并显示虚拟机执行主类名称和进程的本地虚拟机唯一 ID（JVMID，和操作系统进程 ID 一样）。

| 参数 | 作用 |
| :-- | :-- |
| -q | 只输出 LVMID，省略主类的名称 |
| -m | 输出虚拟机进程启动时传给主类 main() 方法的参数 |
| -l | 输出主类的全名 |
| -l | 输出虚拟机进程启动时的 JVM 参数 |


## jmap

Java 内存映像工具，jmap（Memory Map for Java）。jamp 命令用于生成堆转储快照（heapdump 或 dump 文件）。


> 除了 `jmap` 命令，HotSpot VM 提供参数 `-XX:+HeapDumpOnOutOfMemoryError` 在虚拟机发生 OOM 时自动生成 dump 文件。


jmap 除了生成 dump 文件，还可以查询 finalize 执行队列，Java 对和永久代的详细信息，如：空间使用率、当前用的是哪种收集器等。


#### 命令格式
`jmap [option] pid`

| 参数 | 作用 |
| :-- | :-- |
| -dump | 生成 Java 堆转储快照。<br>格式：`-dump:[live,]format=b,file=<filename>`（live 参数表示只 dump 存活的对象） |
| -heap | 显示 Java 堆详细信息，包括：使用哪种回收器、参数配置、分代状况等 |

例如：`jmap -dump:format=b,file=heapdump 5277`