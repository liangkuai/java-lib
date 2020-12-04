# JDK Logging

JDK 提供的日志功能 `java.util.logging`。

局限性，
- Logging 功能在 JVM 启动时读取配置文件并完成初始化，一旦开始运行 main() 方法，就无法修改配置；
- 配置不太方便，需要在 JVM 启动时传递参数 `-Djava.util.logging.config.file=<config-file-name>`。



### 参考
- [使用JDK Logging - 廖雪峰](https://www.liaoxuefeng.com/wiki/1252599548343744/1264738568571776)