# SPI

Service Provider Interface，是 Java 提供的一套用来被第三方实现或者扩展的API，换句话说，**SPI 是一种服务发现机制**。


### 使用

1. 在 jar 包的 `META-INF/services` 目录下创建一个以"接口全限定名"为命名的文件，内容为实现类的全限定名；
2. 接口实现类所在的 jar 包在 classpath 下；
3. 主程序通过 `java.util.ServiceLoader` 动态状态实现模块，它通过扫描 `META-INF/services` 目录下的配置文件找到实现类的全限定名，把类加载到 JVM；
4. SPI 的实现类必须带一个无参构造方法。


### 理解
SPI 其实是一种可插拔技术的总称。最简单的例子就是 USB，厂商提供了 USB 的标准，厂家根据 USB 的标准制造自己的外设，例如鼠标、键盘、游戏手柄等等，但是 USB 标准具体在电脑中是怎么用的，厂家就不需要管了。

回到代码中也是一样的道理。当我们开发一个框架的时候，除了保证基本的功能外，最重要的一个点是什么？我认为最重要的应该是松耦合，即：**对扩展开放、对修改关闭**，保证框架实现对于使用者来说是黑盒。

框架不可能做好所有的事情，只能把共性的部分抽离出来进行流程化，松耦合实现的核心就是定义好足够松散的接口，或者可以理解是扩展点，具体的扩展点让使用者去实现，这样不同的扩展就不需要修改源代码或者对框架进行定制，这就是面向接口编程的好处。

回到我们框架的部分来说：
- JDK 对于 SPI 的实现是通过 `META-INF/services` 这个目录 + `ServiceLoader`。
- Spring 实现 SPI 的方式是留了N多的接口，例如 `BeanPostProcessor`、`InitializingBean`、`DisposableBean`，我们只需要实现这些接口然后注入即可。

对已有框架而言，我们可以通过框架给我们提供的扩展点扩展框架功能。对自己写框架而言，记得 SPI 这个事情，留好足够的扩展点，这将大大加强你写的框架的扩展性。



### 参考
- [JDK SPI - 五月的仓颉](https://www.cnblogs.com/xrq730/p/11440174.html)