# Spring 中的校验

### 依赖
`spring-boot-starter-web` 内包含 `spring-boot-starter-validation` 依赖。


### 使用

#### 嵌套校验
类的成员变量可能是对象，嵌套校验就是对对象进一步校验。

> 需要嵌套校验的字段要加上 `@Valid` 注解。

#### 集合校验
形如，
```java
public class TestDto {

    @NotEmpty
    private List<@Valid User> users;

    ...
}
```

#### 分组校验
在实际项目中，可能有多个方法需要使用同一个实体类来接收参数，但是校验规则可能不一样，例如新增和修改用户用同一个实体类。分组校验就可以解决这个问题。

#### 自定义校验



## 原理

### `ValidatorFactory`
校验器工厂，用来生成校验器 `Validator`。

在 Spring 中，
- 默认使用 `LocalValidatorFactoryBean` 作为实现类，并在启动时注入 Bean；
- `LocalValidatorFactoryBean` 内部包含一个 `ValidatorFactory` 实例，实现类是 `ValidatorFactoryImpl`。


### `Validator`
校验器

从 Spring 中获取的 `ValidatorFactory`（`LocalValidatorFactoryBean`）生成的 `Validator` 实现类是 `ValidatorImpl`。