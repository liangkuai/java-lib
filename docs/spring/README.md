### 0. 如何学习 Spring？

学习一种框架最先需要知道的是为什么需要使用这个框架，任何一个框架的发明都是为了解决编程中的一些痛点。打开任何一本框架的入门书，第一章都是介绍框架的理念和优势。如果需要理解这些理念和优势，那么你需要知道不使用这个框架之前是怎么处理的，才能知道框架做了一些什么事情。

针对 Spring 的学习，第一步就是理解 IoC 和 AOP，这是基础；然后学习 Spring MVC，其实还是 Java EE 开发。如果要理解这个框架，就要知道没有这个框架之前，使用的是什么技术。

> 很多新的技术只不过是引入了新的编程元素对原来技术进行了封装。




### 参考

- [Java新手如何学习Spring、Struts、Hibernate三大框架？ - cod3fn的回答 - 知乎](https://www.zhihu.com/question/21142149/answer/52383396)



## 目录

### IoC
- [intro](/docs/Spring/IoC/README.md)


### AOP
- [intro](/docs/Spring/AOP/README.md)


### Bean
- [intro](/docs/Spring/Bean/README.md)
- [ ] [`BeanDefinition`](/docs/Spring/Bean/BeanDefinition.md)
- [ ] [`BeanPostProcessor`](/docs/Spring/Bean/BeanPostProcessor.md)
- Bean 的生命周期
- 循环依赖问题
    - [x] [1. 构造器注入产生的循环依赖](/docs/Spring/Bean/循环依赖问题/1.构造器注入产生的循环依赖.md)
    - [x] [2. setter 注入产生的循环依赖](/docs/Spring/Bean/循环依赖问题/2.setter注入产生的循环依赖.md)
    - [x] [3. 作用域为 prototype 的 bean 之间的循环依赖](/docs/Spring/Bean/循环依赖问题/3.作用域为prototype的bean之间的循环依赖.md)


### Spring Boot
- [intro](/docs/Spring/SpringBoot/README.md)
- [ ] [自动配置](/docs/Spring/SpringBoot/自动配置.md)
- [x] [Starter](/docs/Spring/SpringBoot/Starter.md)


### 校验
- [ ] [intro](/docs/Spring/校验/README.md)
- [ ] [Spring 中的校验](/docs/Spring/校验/Spring中的校验.md)
    - 嵌套校验
    - 集合校验
    - 分组校验
    - 自定义校验


### 配置
- [ ] Profile


### 测试
- [intro](/docs/Spring/测试/README.md)
- [ ] Spring Boot Test
- [ ] JUnit
- [ ] Mock


### 常用注解
- [intro](/docs/Spring/常用注解/常用注解.md)
    - `@SpringBootApplication`
    - Bean 相关
    - 配置相关
- 配置相关
    - [`@ConfigurationProperties`](/docs/Spring/常用注解/@ConfigurationProperties.md)


### 其他
- [RestTemplate](/docs/Spring/其他/RestTemplate.md)
- [AbstractRoutingDataSource](/docs/Spring/其他/AbstractRoutingDataSource.md)