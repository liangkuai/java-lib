# Starter（启动器）

Spring Boot 由众多 Starter 组成，随着版本的推移 Starter 家族成员也与日俱增。在传统 Maven 项目中通常将一些层、组件拆分为模块来管理，以便相互依赖复用，在 Spring Boot 项目中我们则可以创建自定义 Spring Boot Starter 来达成该目的。


### artifactId 命名
- Spring 官方 Starter 通常命名为 `spring-boot-starter-{name}` 如 `spring-boot-starter-web`；
- Spring 官方建议非官方 Starter 命名应遵循 `{name}-spring-boot-starter` 的格式。


### 自定义 Starter

#### 1. 需要添加的依赖
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter</artifactId>
</dependency>
<dependency>
  <groupId>org.mybatis.spring.boot</groupId>
  <artifactId>spring-boot-autoconfigure</artifactId>
</dependency>
```

#### 2. 创建自动配置类


#### 3. 创建 MATE/spring.factories 文件
MATE 文件夹位于 jar 包中


### 示例
Spring Boot 中常见依赖：
```xml
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.3.2</version>
</dependency>
```

以 MyBatis 的 starter 为例，`mybatis-spring-boot-starter` 的 pom.xml 中包含以下依赖：
```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
  </dependency>
    <dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-autoconfigure</artifactId>
  </dependency>
  <dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
  </dependency>
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
  </dependency>
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
  </dependency>
</dependencies>
```
添加了一个 starter 的依赖，其背后会引入许多其定义的其他依赖，通过 Maven 的传递依赖，这些都会被自动添加了进来。

#### 自动配置
这里 `mybatis-spring-boot-starter` 的自动配置是再通过单独的依赖 `mybatis-spring-boot-autoconfigure` 来实现的。

#### spring.factories
这个文件在依赖项的 jar 包的 MATE-INF 文件夹中。

key 就是 Spring Boot 的 `EnableAutoConfiguration` 类，value 指定了 Spring Boot 用于自动配置的类。
```
# Auto Configure
org.springframework.boot.autoconfigure.EnableAutoConfiguration=org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration
```

#### 自动配置类
也就是 spring.factories 文件中指定的类 `MybatisAutoConfiguration` 。