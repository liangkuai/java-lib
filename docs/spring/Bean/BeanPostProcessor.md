# BeanPostProcessor

后置处理器，用来扩展 Bean 的实例化过程。

```java
public interface BeanPostProcessor {

    /**
     * 前置处理
     *
     * 新实例化的 bean 会被传进来，可以对 bean 做处理
     *
     * 先于 InitialzationBean 的 afterPropertiesSet() 方法执行
     *
     * @return 原有实例，或者包装之后的实例
     */
	@Nullable
	default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

    /**
     * 后置处理
     * 
     * 在 InitialzationBean 完成后执行
     *
     * @return 原有实例，或者包装之后的实例
     */
	@Nullable
	default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
```


### BeanFactoryPostProcessor

`BeanPostProcessor` 用来扩展 Bean 的实例化过程，`BeanFactoryPostProcessor` 用来扩展 BeanFactory 的创建过程。

```java
@FunctionalInterface
public interface BeanFactoryPostProcessor {

	void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
```



### 参考
- [怎么回答面试官：你对Spring的理解？ - bravo1988的回答 - 知乎](https://www.zhihu.com/question/48427693/answer/723146648)
