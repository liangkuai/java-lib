# Class 文件结构

```
ClassFile {
    u4                magic;
    u2                minor_version;
    u2                major_version;

    // 常量池
    u2                constant_pool_count;
    cp_info           constant_pool[constant_pool_count - 1];
    
    // 访问标志，类索引，父类索引
    u2                access_flags;
    u2                this_class;
    u2                super_class;
    
    // 接口索引集合
    u2                interfaces_count;
    u2                interfaces[interfaces_count];
    
    // 字段表
    u2                fields_count;
    field_info        fields[fields_count];
    
    // 方法表
    u2                methods_count;
    method_info       methods[methods_count];
    
    // 类属性表
    u2                attributes_count;
    attribute_info    attributes[attributes_count];
}
```