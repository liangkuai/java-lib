# Log4j

Apache Commons Loggin 可以作为 “日志接口” 来使用，而真正的 “日志实现” 可以使用 Log4j。

#### 架构
Log4j 是一个组件化设计的日志系统，它的架构大致如下：

![Log4j](/assets/images/Java/日志/log4j.png)

1. 当我们使用 Log4j 输出一条日志时，Log4j 自动通过不同的 Appender 把同一条日志输出到不同的目的地。例如：
    - console：输出到屏幕；
    - file：输出到文件；
    - socket：通过网络输出到远程计算机；
    - jdbc：输出到数据库
2. 在输出日志的过程中，通过 Filter 来过滤哪些 log 需要被输出，哪些 log 不需要被输出。例如，仅输出 ERROR 级别的日志。
3. 最后，通过 Layout 来格式化日志信息，例如，自动添加日期、时间、方法名称等信息。

上述结构虽然复杂，但我们在实际使用的时候，并不需要关心 Log4j 的 API，而是通过配置文件来配置它。

以 XML 配置为例，使用 Log4j 的时候，我们把一个 log4j2.xml 的文件放到 classpath 下就可以让 Log4j 读取配置文件并按照我们的配置来输出日志。



### 参考
- [使用Log4j - 廖雪峰](https://www.liaoxuefeng.com/wiki/1252599548343744/1264739436350112)
