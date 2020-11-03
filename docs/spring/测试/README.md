# Spring Boot 下的测试

Spring Boot 提供了许多实用程序和注释以帮助测试应用程序。测试支持由两个模块提供：
- `spring-boot-test` ：包含核心项目
- `spring-boot-test-autoconfigure` ：支持测试的自动配置

大多数开发人员使用 `spring-boot-starter-test`，它可以很方便的导入 Spring Boot 测试模块，包含了 `spring-boot-test` 和 `spring-boot-test-autoconfigure`，以及 `JUnit`，`AssertJ`，`Hamcrest`和其他一些有用的库。

#### `spring-boot-starter-test`
包含以下库：
- JUnit：Java 程序的单元测试标准
- Spring Test & Spring Boot Test：Spring Boot应用程序的实用程序和集成测试支持
- AssertJ：断言库
- Hamcrest:：配器对象库（也称为约束或谓词）
- Mockito：Java mock 框架
- JSONassert：JSON的断言
- JsonPath：XPath for JSON