# Profile

Spring Profiles 提供了一种分离部分应用程序配置的方法，并使其仅在特定环境中可用。可以对不同环境或者指令来读取不同的配置文件。

1. 可以使用 `spring.profiles.active` 环境属性来指定哪些配置文件处于活动状态。一种方式是将此配置写入 `application.properties` 文件。

2. 可以使用 `@Profile `标记任何 `@Component` 或 `@Configuration`，以限制何时加载。

```java
@Configuration
@Profile("production")
public class ProductionConfiguration {

    // ...
}
```