# 标准IO

按照标准 I/O 模型，Java 提供了
- `System.in`
- `System.out`
- `System.err`

以下是相关源代码。

```java
public final class System {
    public final static InputStream in = null;
    public final static PrintStream out = null;
    public final static PrintStream err = null;

    public static void setIn(InputStream in) {
            checkIO();
            setIn0(in);
    }
    public static void setOut(PrintStream out) {
            checkIO();
            setOut0(out);
    }
    public static void setErr(PrintStream err) {
        checkIO();
        setErr0(err);
    }

    private static native void setIn0(InputStream in);
    private static native void setOut0(PrintStream out);
    private static native void setErr0(PrintStream err);
}
```

#### 进一步装饰
`System.out` 和 `System.err` 均被包装成 `PrintStream` 实例，而 `System.in` 却是一个没有包装的 `InputStream`。
- 如果需要使用标准输入，需要先对 `System.in` 进行包装。例如：包装成 `BufferedReader` 按行读取输入。
- 同样，可以对 `System.out` 和 `System.err` 进一步包装，例如：包装成 `PrintWriter`。


#### 重定向
`System` 类提供了 static setter，以允许我们对标准输入、输出和错误 I/O 流进行重定向。