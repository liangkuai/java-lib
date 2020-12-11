# JDK

JDK = JRE + JVM + ...

- JDK（Java Development Kit，Java 开发套件）
- JRE（Java Runtime Environment，Java 运行环境）
- JVM（Java Virtual Machine，Java 虚拟机）


## Java 环境变量

从 Oracle 官方下载的 JDK 中包含了 JRE。进行 Java 开发则需要配置 Java  开发环境。

```bash
JAVA_HOME=JDK安装目录

CLASSPATH=.;%JAVA_HOME%/lib/dt.jar;%JAVA_HOME%/lib/tools.jar;

# PATH 添加如下内容
PATH=%JAVA_HOME%/bin;%JAVA_HOME%/jre/bin;
```

### PATH

PATH 包含的两个路径分别是 JDK 和 JRE 下的 bin。主要是为了能让系统在任何路径下运行里面的二进制文件。


### CLASSPATH

CLASSPATH 的作用是告诉 JVM 要加载的 class 文件路径。

#### 1. `tools.jar`

工具类库，它跟我们程序中用到的基础类库没有关系。我们注意到在 PATH 中变量值 bin 目录下的各个 exe 工具的大小都很小，一般都在 27KB 左右，这是因为它们实际上仅仅相当于是一层代码的包装，这些工具的实现所要用到的类库都在 `tools.jar` 中，用压缩软件打开 `tools.jar` 会发现有很多文件是和 bin 目录下的 exe 工具相对的。

当然，如果 `tools.jar` 的功能只有这些的话，那么我们根本不用把它加入到 CLASSPATH 变量中，因为 bin 目录下的工具自己可以完成对这些类库的调用，因此 `tools.jar` 应该还有其他的功能。在里面还可以看到有 Applet 和 RMI 等 相关的文件，因此 `tools.jar` 应该还是远程调用等必须的 jar 包。


#### 2. `dt.jar`

运行环境类库，主要是 Swing 包，这一点通过用压缩软件打开 dt.jar 也可以看到。**如果在开发时候没有用到 Swing 包，那么可以不用将 `dt.jar` 添加到 CLASSPATH 变量中。**


#### 3. `.`

CLASSPATH 变量中的 `.` 代表当前目录。类加载器会从 Java 源代码所在的目录中加载 class 文件。


#### 注意

以上这三个 CLASSPATH 变量内容没有基本类库（指所有的 `java.*` 开头的类）和扩展类库（如 `javax.*` 开头的类），也就是我们程序中经常 import 的那些 jar 包。

- 在 Java 类加载机制中可以了解到，CLASSPATH 中的这些类都是由 `AppClassLoader` 或者我们自定义的类加载器来加载的，这里当然不能包括基础类库，如果包括基础类库的话，用两个不同的自定义类加载器去加载该基础类，那它得到的该基础类就不是唯一的了，这样就不能保证 Java 类的安全性。

- 实际上，这些基础类库都在 `%JAVA_HOME%/jre/lib` 目录下（如其中的 `rt.jar`、`resource.jar`），Java 类加载机制中也有提到，该目录下的类（在 jar 包中）会由 `BootstrapClassLoader` 自动加载，并通过双亲委派模型保证了基础类库只会被 `BootstrapClassLoader` 加载，这也就保证了基础类的唯一性。

- 另外，扩展类库在 `%JAVA_HOME%/jre/lib/ext` 目录下，该目录下的类是由 `ExtClassLoader` 来加载的，有时候我们也要 import 这里面的类，但是并没有基础类库用的频繁。同样，`ExtensionClassLoader` 也会自动到该目录下找扩展类，而不需要我们指定。


### 参考

- [详细说明JDK环境变量中dt.jar、tools.jar等变量值的作用（结合ClassLoader）](https://blog.csdn.net/ns_code/article/details/18547959)