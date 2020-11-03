# 校验

Java API 规范（JSR 303、349、380）定义了 Bean 的校验标准 `validation-api`，没有提供实现。
- `hibernate-validator` 提供了实现，并增加了校验注解，如 @Email、@Length 等。
- `spring-boot-starter-validation` 是对 `hibernate-validation` 的二次封装，用于支持 Spring MVC 参数校验。



### 常用校验注解

| 注解 | 校验规则 |
| --- | --- |
| `@AssertTrue` | 被注释的元素必须为 true |
| `@AssertFalse` | 被注释的元素必须为 false |
| `@DecimalMin(value)` | 被注释的元素必须是一个数字，其值必须大于等于指定的最小值 |
| `@DecimalMax(value)` | 被注释的元素必须是一个数字，其值必须小于等于指定的最大值 |
| `@Digits(integer, fraction)` | 被注释的元素必须是一个数字，且整数和小数必须是指定位数 |
| `@Min(value)` | 被注释的元素必须是一个数字，其值必须大于等于指定的最小值 |
| `@Max(value)` | 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
| `@Null` | 被注释的元素必须为 null |
| `@NotNull` | 被注释的元素必须不为 null |
| `@NotEmpty` | 被注释的字符串、集合、数组不能为 null 也不能为空 |
| `@NotBlank` | 被注释的字符串非 null，并且必须包含一个非空白字符 |
| `@Size(max=, min=)` | 被注释的字符串、集合、数组的大小必须在指定的范围内 |
| `@Past` | 被注释的元素必须是一个过去的日期 |
| `@PastOrPresent` | 被注释的元素必须是一个过去的日期或现在 |
| `@Future` | 被注释的元素必须是一个将来的日期 |
| `@FutureOrPresent` | 被注释的元素必须是一个将来的日期或现在 |
| `@Pattern(regex=,flag=)` | 被注释的元素必须符合指定的正则表达式 |
| `@Email` | 被注释的元素必须是 Email 格式 |
