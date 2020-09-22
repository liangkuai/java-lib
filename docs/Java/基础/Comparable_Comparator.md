# Comparable / Comparator

### `java.lang.Comparable`

如果一个类实现了 `Comparable` 接口，表示该类“可排序”。可以直接使用 `Arrays.sort()` 和 `Collections.sort()` 排序。

```java
package java.lang;

public interface Comparable<T> {
    public int compareTo(T o);
}
```


### `java.util.Comparator`

比较器接口。对于不可排序的类 A（没有实现 `Comparable` 接口），可以创建一个比较器类 C，专门用来对 A 进行排序。

```java
package java.util;

public interface Comparator<T> {
    int compare(T o1, T o2);
	boolean equals(Object obj);
    ...
}
```

### 区别

`Comparable` 相当于“内部比较器”，对实现类进行排序；而 `Comparator` 相当于“外部比较器”，对泛型 T 进行排序。
