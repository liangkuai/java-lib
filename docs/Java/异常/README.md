# 异常

Java 中的异常体系

![异常结构](/assets/images/Java/异常/异常结构.png)

从继承关系可知：`Throwable` 是异常体系的顶级基类。`Throwable` 有两个体系：`Error` 和 `Exception`。

`Error` 表示严重的错误，程序对此一般无法处理，例如，
- `OutOfMemoryError`
- `NoClassDefFoundError`

`Exception` 表示程序可以处理的异常，其中 `Exception` 又分为两大类，
- `RuntimeException` 以及它的子类；
- 非 `RuntimeException`

> Java规定：
> - 必须捕获的异常，包括 `Exception` 及其子类，但不包括 `RuntimeException` 及其子类，这种类型的异常称为 Checked Exception。
> - 不是必须捕获的异常，包括 `Error` 及其子类，`RuntimeException` 及其子类。
>
> 编译器对 `RuntimeException` 及其子类不做强制捕获要求，不是指应用程序本身不应该捕获并处理 `RuntimeException`。是否需要捕获，具体问题具体分析。



### 参考
- [Java的异常 - 廖雪峰](https://www.liaoxuefeng.com/wiki/1252599548343744/1264734349295520)