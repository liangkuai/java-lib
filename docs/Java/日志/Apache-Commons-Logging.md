# Apache Commons Logging

与 JDK 提供的日志功能不同，Apache Commons Logging 是一个 Apache 的第三方日志库。

Apache Commons Logging 的特色是，它可以挂接不同的日志系统，并通过配置文件指定挂接的日志系统。默认情况下，Apache Commons Logging 自动搜索并使用 Log4j，如果没有找到再使用 JDK Logging。


#### 使用
1. 通过 `LogFactory` 获取 `Log` 类的实例;
2. 使用 `Log` 实例的方法打日志。

#### 日志级别（由高到低）
- FATAL
- ERROR
- WARNING
- INFO（默认）
- DEBUG
- TRACE



### 参考
- [使用Commons Logging - 廖雪峰](https://www.liaoxuefeng.com/wiki/1252599548343744/1264738932870688)
