# AbstractRoutingDataSource

抽象类 `AbstractRoutingDataSource`，继承 `AbstractDataSource`，通过扩展这个类实现根据不同的请求切换数据源。

如果声明一个类 `DynamicDataSource` 继承 `AbstractRoutingDataSource` 后，`DynamicDataSource` 本身就相当于一种数据源。所以 `AbstractRoutingDataSource` 必然有 `getConnection()` 方法获取数据库连接。

```java
@Override
public Connection getConnection() throws SQLException {
    return determineTargetDataSource().getConnection();
}

@Override
public Connection getConnection(String username, String password) throws SQLException {
    return determineTargetDataSource().getConnection(username, password);
}
```

而 `AbstractRoutingDataSource` 的 `getConnection()` 方法里实际是调用 `determineTargetDataSource()` 返回的数据源的 `getConnection()` 方法。接着看 `determineTargetDataSource()` 方法：

```java
protected DataSource determineTargetDataSource() {
    Assert.notNull(this.resolvedDataSources, "DataSource router not initialized");
    Object lookupKey = determineCurrentLookupKey();
    DataSource dataSource = this.resolvedDataSources.get(lookupKey);
    if (dataSource == null && (this.lenientFallback || lookupKey == null)) {
        dataSource = this.resolvedDefaultDataSource;
    }
    if (dataSource == null) {
        throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + lookupKey + "]");
    }
    return dataSource;
}
```

大致流程为，
- 通过 `determineCurrentLookupKey()` 方法获取一个key，
- 通过 key 从 `resolvedDataSources` 中获取数据源 `DataSource` 对象。

`determineCurrentLookupKey()` 是个抽象方法，需要继承 `AbstractRoutingDataSource` 的类实现；而 `resolvedDataSources` 是一个 `Map<Object, DataSource>`，里面应该保存当前所有可切换的数据源。