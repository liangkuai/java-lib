# String / StringBuffer / StringBuilder

### String

`String` 使用 `final` 修饰字符数组，所以 `String` 对象不可变。

```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {

    private final char value[];
    private int hash;
    public static final Comparator<String> CASE_INSENSITIVE_ORDER = new CaseInsensitiveComparator();
}
```

> 在 Java 9 之后，`String` 类的实现改用 `byte` 数组存储字符串：`private final byte[] value;`


### StringBuffer / StringBuilder

`StringBuffer` 和 `StringBuilder` 都继承自 `AbstractStringBuilder` 类，在 `AbstractStringBuilder` 中也是使用字符数组保存字符串 `char[] value`，但是没有用 `final` 关键字修饰，字符串是可变的。

```java
abstract class AbstractStringBuilder implements Appendable, CharSequence {
    char[] value;
    int count;

    AbstractStringBuilder() {}

    AbstractStringBuilder(int capacity) {
        value = new char[capacity];
    }
}
```

#### 1. 线程安全
- `String` 中的对象是不可变的，也就可以理解为常量，线程安全。
- `StringBuffer` 对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。
- `StringBuilder` 没有对方法进行加同步锁，所以是非线程安全的。

#### 2. 性能
- 每次对 `String` 类型进行改变的时候，都会生成一个新的 String 对象，然后将引用指向新的 String 对象。
- `StringBuffer` 每次都会对 `StringBuffer` 对象本身进行操作，而不是生成新的对象并改变对象引用。
- 相同情况下使用 `StringBuilder` 相比使用 `StringBuffer` 仅能获得 10% ~ 15% 左右的性能提升，但可能有线程安全问题。