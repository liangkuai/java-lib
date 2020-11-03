# @ConfigurationProperties

通过 `@ConfigurationProperties` 读取配置信息并与 bean 绑定。

根据一个前缀，将配置文件中对应前缀的配置项，注入到 Bean 的属性中。


例如，配置一个数据源，

#### 1. 在配置文件中添加配置项
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=test
spring.datasource.password=test
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.test-on-borrow=true
spring.datasource.test-while-idle=true
spring.datasource.time-between-eviction-runs-millis=3600000
```

#### 2. 定义配置 Bean
```java
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private boolean testOnBorrow;
    private boolean testWhileIdle;
    private int timeBetweenEvictionRunsMillis;

    // 省略 setter 和 getter 方法
    ...
}
```

也可以直接使用在 `@Bean` 注解的 Bean 上，直接给返回的 Bean 的属性注入值。
```java
@Bean(name = "main")
@ConfigurationProperties(prefix = "spring.datasource")
public DataSource mainDataSource() {
    return DataSourceBuilder.create().build();
}
```