# AOP





### Aspect（切面）

由 PointCut 和 Advice 组成；其中，
- PointCut 定义连接点（JoinPoint）的匹配模式，符合模式的连接点就是切面的切入点；
- Advice 定义需要添加到连接点（JoinPoint）处的功能逻辑。

> Spring AOP 就是实施切面的框架，负责将 Aspect 的 Advice 织入符合 PointCut 的 JoinPoint 中。

#### 1. PointCut（切点）
PointCut 就是匹配 JoinPoint 的谓词，**本质上就是一个匹配模式**。每个 Advice 都会关联一个 PointCut，**符合模式的 JoinPoint 才会添加 Advice。**

#### 2. JoinPoint（连接点）
代码中被 Advice 的地方。

> 在 Spring AOP 中，一般都是方法。

#### 3. Advice（增强）
**本质上就是一段代码**，实现了一些功能逻辑。**作用上就是添加到 JoinPoint 处用来增强连接点的功能。**

> 在 Spring AOP 中，将 Advice 当做一个拦截器（interceptor）添加到 JoinPoint 处来实现代理。