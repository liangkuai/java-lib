# SLF4J 和 Logback

SLF4J 和 Logback 也类似于 Apache Commons Logging 和 Log4j，一个是日志 API，一个负责实现日志底层。

因为对 Apache Commons Logging 的接口不满意，有人就搞了 SLF4J。因为对 Log4j 的性能不满意，有人就搞了 Logback。


#### 使用
对比一下 Apache Commons Logging 和 SLF4J 的接口，

| Apache Commons Logging | SLF4J |
| :-- | :-- |
| `org.apache.commons.logging.Log` | `org.slf4j.Logger` |
| `org.apache.commons.logging.LogFactory` | `org.slf4j.LoggerFactory` |

不同之处就是 `Log` 变成了 `Logger`，`LogFactory` 变成了 `LoggerFactory` 。和 Log4j 类似，我们仍然需要一个 Logback 的配置文件，把 `logback.xml` 放到 classpath 下。


#### 原理
- [Java日志框架：slf4j作用及其实现原理 - 五月的仓颉](https://www.cnblogs.com/xrq730/p/8619156.html)
- [Java日志框架：logback详解 - 五月的仓颉](https://www.cnblogs.com/xrq730/p/8628945.html)


### 参考
- [使用SLF4J和Logback - 廖雪峰](https://www.liaoxuefeng.com/wiki/1252599548343744/1264739155914176)
