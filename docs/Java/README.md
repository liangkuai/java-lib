# Java

### [JDK](/docs/Java/JDK.md)

### 基础
- [x] [数据类型](/docs/Java/基础/数据类型.md)
- [x] [`==` 和 `equals()`](/docs/Java/基础/==和equals().md)
- [x] [Comparable / Comparator](/docs/Java/基础/Comparable_Comparator.md)


### 类
- [x] [内部类](/docs/Java/类/内部类.md)
    - [x] 静态内部类


### [异常]()


### 并发
- 线程
    - [x] [线程的状态](/docs/Java/JVM/并发/Java与线程/线程的状态.md)
    - [ ] [创建线程](/docs/Java/并发/线程/创建线程.md)
    - [x] [中断](/docs/Java/并发/线程/中断.md)
    - 线程间的协作
        - [ ] [`java.lang.Thread` 相关（sleep / join / yield）](/docs/Java/并发/线程/线程间的协作/thread.md)
        - [ ] [`java.lang.Object` 相关（wait / notify / notifyAll）](/docs/Java/并发/线程/线程间的协作/object.md)
- 线程池
    - [intro](/docs/Java/并发/线程池)
    - [x] [ThreadPoolExecutor](/docs/Java/并发/线程池/ThreadPoolExecutor.md)
        - [x] [FixedThreadPool](/docs/Java/并发/线程池/FixedThreadPool.md)
        - [x] [SingleThreadExecutor](/docs/Java/并发/线程池/SingleThreadExecutor.md)
        - [x] [CachedThreadPool](/docs/Java/并发/线程池/CachedThreadPool.md)
    - [ ] [ScheduledThreadPoolExecutor](/docs/Java/并发/线程池/ScheduledThreadPoolExecutor.md)
        - [ ] Quartz
    - [x] [线程池最佳实践](/docs/Java/并发/线程池/线程池最佳实践.md)
- 并发控制策略
    - [悲观并发控制](/docs/Java/并发/并发控制策略/悲观并发控制)
        - [ ] [`synchronized` 关键字](/docs/Java/JVM/并发/Java与线程/synchronized.md)
    - [乐观并发控制](/docs/Java/并发/并发控制策略/乐观并发控制)
        - [x] [CAS](/docs/Java/并发/并发控制策略/乐观并发控制/CAS.md)
        - [x] [自旋锁](/docs/Java/并发/并发控制策略/乐观并发控制/自旋锁.md)
    - 无同步策略
        - [ ] [ThreadLocal](/docs/Java/并发/并发控制策略/ThreadLocal.md)
- J.U.C
    - [x] [Atomic 原子类](/docs/Java/并发/JUC/Atomic原子类.md)
    - [ ] [LockSupport](/docs/Java/并发/JUC/LockSupport.md)
    - [ ] [AQS]()
        - [ ] [Semaphore](/docs/Java/并发/JUC/AQS/Semaphore.md)
        - [ ] [CountDownLatch](/docs/Java/并发/JUC/AQS/CountDownLatch.md)
        - [ ] [CyclicBarrier](/docs/Java/并发/JUC/AQS/CyclicBarrier.md)


## JVM

### 类加载子系统
- [x] [类加载过程](/docs/Java/JVM/类加载子系统/类加载过程.md)
    - 加载
    - 连接
        - 验证
        - 准备
        - 解析
    - 初始化
        - [ ] 类初始化和接口初始化的区别
    - [ ] 卸载
    - [ ] 数组类型的加载过程
- [x] [类加载器](/docs/Java/JVM/类加载子系统/类加载器.md)
    - 内置类加载器
    - 双亲委派模型
    - 自定义类加载器


### JVM 运行时数据区域
- [intro](/docs/Java/JVM/JVM运行时数据区域/README.md)
- [x] [1. 程序计数器](/docs/Java/JVM/JVM运行时数据区域/程序计数器.md)
- [x] [2. Java 虚拟机栈](/docs/Java/JVM/JVM运行时数据区域/Java虚拟机栈.md)
- [x] [3. 本地方法栈](/docs/Java/JVM/JVM运行时数据区域/本地方法栈.md)
- [x] [4. 堆](/docs/Java/JVM/JVM运行时数据区域/堆.md)
- [x] [5. 方法区](/docs/Java/JVM/JVM运行时数据区域/方法区.md)
    - 方法区与永久代
    - 方法区与元空间
- [x] [6. 运行时常量池](/docs/Java/JVM/JVM运行时数据区域/运行时常量池.md)
- [ ] [7. 直接内存](/docs/Java/JVM/JVM运行时数据区域/直接内存.md)
    - 元空间


### [HotSpot VM - 堆中的对象](/docs/Java/JVM/HotSpot中的对象.md)
- [x] 对象的创建过程
- [x] 对象在内存中存储的内容
    - 类型指针
    - 对象自身的运行时数据（Mark Word）
    - 数组长度
- [x] 对象的访问定位


### JVM 垃圾回收
- [intro](/docs/Java/JVM/JVM垃圾回收/README.md)
- [x] [对象存活判断](/docs/Java/JVM/JVM垃圾回收/对象存活判断.md)
    - 引用计数法
    - 可达性分析性
- [x] [关于引用类型](/docs/Java/JVM/JVM垃圾回收/关于引用类型.md)
- [x] [GC 算法](/docs/Java/JVM/JVM垃圾回收/GC算法.md)
    - 分代收集理论
    - 标记-清除
    - 标记-复制
    - 标记-整理
- [ ] [垃圾回收器](/docs/Java/JVM/JVM垃圾回收/垃圾回收器.md)
- [x] [内存分配和回收策略](/docs/Java/JVM/JVM垃圾回收/内存分配和回收策略.md)
- [ ] [GC 策略](/docs/Java/JVM/JVM垃圾回收/GC策略.md)


### Class 文件结构
- [ ] 方法表
    - [ ] 属性表
        - [ ] Code
        - [ ] Exceptions
- [ ] 属性表


### 字节码执行引擎
- [ ] 运行时栈帧
    - [ ] 局部变量表
    - [ ] 操作数栈
    - [ ] 动态链接
    - [ ] 方法返回地址


### 并发
- [x] [Java 内存模型](/docs/Java/JVM/并发/Java内存模型/README.md)
    - [ ] [内存间的交互操作](/docs/Java/JVM/并发/Java内存模型/内存间的交互操作.md)
    - [ ] [volatile]()
        - 内存屏障
    - [ ] [JMM 三大特性]()
    - [ ] [先行发生原则]()
- [x] [Java 与线程](/docs/Java/JVM/并发/Java与线程/README.md)
    - [x] [线程的状态](/docs/Java/JVM/并发/Java与线程/线程的状态.md)
    - [x] [线程安全](/docs/Java/JVM/并发/Java与线程/线程安全.md)
        - 线程安全的实现方式
            - 互斥同步（悲观并发控制）
                - [ ] [`synchronized` 关键字](/docs/Java/JVM/并发/Java与线程/synchronized.md)
                    - Monitor
                - [ ] [ReentrantLock]()
            - 非阻塞同步（乐观并发控制）
            - 无同步方案
- [x] [(synchronized) 锁优化](/docs/Java/JVM/并发/Java与线程/锁优化.md)
    - 自旋锁与自适应
    - 轻量级锁
    - 偏向锁
    - 锁消除
    - 锁粗化
- [ ] 死锁


### 编译及优化
- 前端
    - 词法分析
    - 语法分析
    - 字节码生成
- 后端
    - 解释器
    - 编译器
    - 编译优化技术
        - [x] [逃逸分析](/docs/Java/JVM/编译及优化/逃逸分析.md)


### [JVM 参数](/docs/Java/JVM/JVM参数.md)
- 内存相关
    - 堆
    - 新生代
    - 永久代
    - 元空间
- GC 相关
- 并发
    - 锁