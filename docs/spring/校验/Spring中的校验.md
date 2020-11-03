# Spring 中的校验

### `ValidatorFactory`
校验器工厂，用来生成校验器 `Validator`。

在 Spring 中，
- 默认使用 `LocalValidatorFactoryBean` 作为实现类，并在启动时注入 Bean；
- `LocalValidatorFactoryBean` 内部包含一个 `ValidatorFactory` 实例，实现类是 `ValidatorFactoryImpl`。


### `Validator`
校验器

从 Spring 中获取的 `ValidatorFactory`（`LocalValidatorFactoryBean`）生成的 `Validator` 实现类是 `ValidatorImpl`。