# RestTemplate

常用于调用远程 REST 服务。

由于 `RestTemplate` 实例经常需要在使用之前进行定制，因此 Spring Boot 不提供任何自动配置的 `RestTemplate` bean，但是，它会自动配置一个 `RestTemplateBuilder`，可用于在需要的时候使用 `RestTemplateBuilder` 创建 `RestTemplate` 实例。自动配置的 `RestTemplateBuilder` 将确保将合理的 `HttpMessageConverters` 应用于 `RestTemplate` 实例。

```java
@Service
public class MyBean {
    private final RestTemplate restTemplate;

    public MyBean(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

        // RestTemplateBuilder包含许多可用于快速配置RestTemplate的有用方法
        // 例如，要添加BASIC认证支持，可以使用
        // this.restTemplate = restTemplateBuilder.basicAuthorization("user"，"password").build();
    }

    public Details someRestCall(String name) {
        return this.restTemplate.getForObject("/{name}/details", Details.class, name);
    }
}
```

### 自定义 `RestTemplate`
`RestTemplate` 自定义有三种主要方法，具体取决于您希望自定义应用的范围。

1. 类范围。为了尽可能缩小任何自定义的范围，请注入自动配置的 `RestTemplateBuilder`，然后根据需要调用其方法。如上述代码，建造者模式中每个方法调用都会返回一个新的 `RestTemplateBuilder` 实例。这是在构造器内来配置，自定义的 `RestTemplate` 应用范围是一个类。

2. 应用范围。要对整个应用程序范围的附加定制，可以使用 `RestTemplateCustomizer` bean。所有这些 bean 都会自动注册到自动配置的 `RestTemplateBuilder` 中，并将应用于随其构建的任何 `RestTemplate`。

以下是一个定制程序示例，它为 `192.168.0.5` 以外的所有主机配置代理的使用：
```java
static class ProxyCustomizer implements RestTemplateCustomizer {
    @Override
    public void customize(RestTemplate restTemplate) {
        HttpHost proxy = new HttpHost("proxy.example.com");
        HttpClient httpClient = HttpClientBuilder.create()
                .setRoutePlanner(new DefaultProxyRoutePlanner(proxy) {

                    @Override
                    public HttpHost determineProxy(HttpHost target,
                            HttpRequest request, HttpContext context)
                            throws HttpException {
                        if (target.getHostName().equals("192.168.0.5")) {
                            return null;
                        }
                        return super.determineProxy(target, request, context);
                    }

                }).build();
        restTemplate.setRequestFactory(
                new HttpComponentsClientHttpRequestFactory(httpClient));
    }
}
```

3. 最后，最极端的（也是很少使用的）选项是创建你自己的 `RestTemplateBuilder` bean。这将关闭 `RestTemplateBuilder` 的自动配置，并阻止使用任何 `RestTemplateCustomizer` bean。


### HTTP 连接池
`RestTemplate` 默认不使用连接池，如果想使用则需要一个 `ClientHttpRequestFactory` 接口的实现类来池化连接。例如使用 `HttpComponentsClientHttpRequestFactory`。

```java
RestTemplate restT = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
```

> `HttpComponentsClientHttpRequestFactory` 是 `org.springframework.http.client.ClientHttpRequestFactory` 的实现类，它底层使用了 Apache HttpComponents HttpClient 来创建请求.

### 另外
以上是 Spring Boot 2.0 以下的远程 REST 服务调用方式，在 Spring Boot 2.0 开始增加了`WebClient`方式。详情参见官方文档。


### 异步调用


### 参考
- [Spring Boot 1.5.13.RELEASE Reference Guide](https://docs.spring.io/spring-boot/docs/1.5.13.RELEASE/reference/htmlsingle/#boot-features-restclient)