## 引言
简单示例：
https://gitee.com/xbd521/spring-security-oauth2-sso-sample

视频讲解：
【阿里二面：什么是SSO、与OAuth2.0有什么关系?问麻了。。。】 https://www.bilibili.com/video/BV1kX4y17712/?share_source=copy_web&vd_source=1a9dd50b5a85eba039efa99d138b6bed

IAM（Identity and Access Management ），即“身份识别与访问管理”，具有单点登录、强大的认证管理、基于策略的集中式授权和审计、动态授权、企业可管理性等功能。

IAM结构至上而下从租户、用户池、应用、用户、组织、权限、属性层层配置，通过各个模块对用户在认证、权限等方面进行控制。租户在saas产品上用的比较频繁，通常企业也会管理saas的租户，通过IAM来限制saas租户的访问认证，功能更多的IAM甚至会用来监控流量、付费情况等。

IAM最核心的功能上是认证、账号管理、权限授权、审计功能。

在样式交互上，基于IAM是一个给管理人员使用的操作系统，降低用户学习成本，提高工作效率是首要考虑的事情。
## SpringSecurity6.2.3 
### 快速入门
spring官方simple示例入口：https://docs.spring.io/spring-security/reference/samples.html

spring-security示例代码：https://github.com/spring-projects/spring-security-samples

- springsecurity给我们提供做了哪些事情呢？
> 1、保护应用程序URL


> 2、应用程序启动默认用户user和随机生成的密码在后台控制台中


> 3、生成默认的登录页面(login)和登出页面 /logout


> 4、提供基于表单的登录和注销的流程


> 5、对于HTTP请求重定向到登录页面


> 6、对于服务请求，返回401未授权


> 7、跨请求伪造（CSRF）攻击


> 8、会话劫持攻击


> 9、Strict-Transport-Security确保HTTPS协议


> 10、X-Content-Type-Options处理嗅探攻击


> 11、Cache Control头保护身份验证后的资源


> 12、X-Frame-Options处理点击劫持攻击


### 原理分析
基于 Servlet Filters 默认过滤器链`DefaultSecurityFilterChain`过滤所有请求实现接口 `SecurityFilterChain`
spring-security官方文档介绍：https://docs.spring.io/spring-security/reference/servlet/architecture.html

Q：在spring-security的servlet中的FilterChain是如何在security框架管理API请求的呢？

- 核心实现类public final class DefaultSecurityFilterChain implements SecurityFilterChain
- 核心配置类@ConfigurationProperties(prefix = "spring.security")

以上两个类在servlet中ApplicationContext中执行FilterChain中管理身份认证、角色信息、用户授权信息等？
## SpringSecurity自定义配置
自定义配置内容官方文档参考介绍：https://docs.spring.io/spring-security/reference/servlet/configuration/java.html

Q：security框架在springboot启动后如何通过@EnableWebSecurity开启身份认证InMemoryUserDetailsManager基于内存中的用户信息进行管理呢？依据前者的模式自定义一个DBUserDetailsManager基于数据库的用户信息、身份认证、授权用户等管理？

Q：security如何通过FilterChain对用户填写的表单信息进行验证的呢？常见默认的配置有哪些呢？


Q：security提供不同的加密方式在存储到数据库中用户数据如何选择合适的加密策略呢？不同的密文编码策略如何设置要保存的密文内容的呢？

{bcrypt}$2a$04$xQJzkYw550OfXxEqIbt75Ogwm.P7IE9KYKGvrkCu05Ujw7zQrzwxK
## 前后端分离
### 用户认证流程
security官网介绍：https://docs.spring.io/spring-security/reference/servlet/authentication/architecture.html

Q：security在FilterChain到AuthenticationManager中是如何验证用户身份认证、注销操作、对用户访问会话如何进行管理的呢？

Q：security是如何获取通过身份认证后的用户信息？

Q：security在身份认证持久化后的会话策略如何管理，如何处理超时会话管理呢？


## 授权
security官方介绍：https://docs.spring.io/spring-security/reference/servlet/authorization/index.html

### requet用户-权限-资源授权
需求：拥有USER_LIST的权限的用户可以访问/user/list路径；拥有USER_ADD的权限的用户可以访问/user/add路径；拥有USER_DELETE的权限的用户可以访问/user/delete/{id}路径

### request用户-角色-资源
需求：拥有角色名为ADMIN可以访问/user/**路径下所有资源；拥有角色名为COMMON可以访问/user/list路径下的资源

### 用户-角色-权限-资源
RBAC（Role-Based Access Control）其基本思想是，对系统操作的各种权限不是直接授予具体的用户，而是在用户集合与权限集合之间建立一个角色集合。每一种角色对应一组相应的权限。一旦用户被分配了适当的角色后，该用户就拥有此角色的所有操作权限。这样做的好处是，不必在每次创建用户时都进行分配权限的操作，只要分配用户相应的角色即可，而且角色的权限变更比用户的权限变更要少得多，这样将简化用户的权限管理，减少系统的开销。转换成结合数据库的设计获取用户-角色-权限，跟security没联系。


security中在方法中的授权：https://docs.spring.io/spring-security/reference/servlet/authorization/method-security.html

## OAuth2
security介绍的oauth2登录：https://docs.spring.io/spring-security/reference/servlet/oauth2/index.html

在medius上一篇文章oauth2的文章：https://medium.com/@darutk/the-simplest-guide-to-oauth-2-0-8c71bd9a15bb

https://datatracker.ietf.org/doc/rfc6749/

OAuth2包括资源所有者、客户应用、资源服务器、授权服务器

OAuth2的使用场景：

- 第三方社交登录


- 开放API


- 企业内部应用认证授权
   - SSO单点登录


   - IAM身份识别和访问管理

### 四种授权模式

oauth2四种授权模式介绍：https://datatracker.ietf.org/doc/rfc6749/

#### 授权码模式
重点：oauth2授权流程：
![image.png](https://cdn.nlark.com/yuque/0/2024/png/29512941/1712412811954-d0f72527-42dc-4146-9971-0ead4469b2d8.png#averageHue=%23fdfcfc&clientId=u2a7a32db-6914-4&from=paste&height=473&id=ube7efabc&originHeight=600&originWidth=683&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=96211&status=done&style=none&taskId=u46bd0ebd-4b35-4af4-b5cb-46b86ecf114&title=&width=538.4000244140625)



#### 隐藏式

![image.png](https://cdn.nlark.com/yuque/0/2024/png/29512941/1712413599242-187cf7b2-4891-4423-b7f6-8bcfb46e7632.png#averageHue=%23fefefd&clientId=u2a7a32db-6914-4&from=paste&height=518&id=u8d1b47fe&originHeight=773&originWidth=942&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=52237&status=done&style=none&taskId=u83047bcd-2796-4464-8048-24c097cba9c&title=&width=631)


## OAuth2社交登录案例
oauth2官网示例：https://github.com/spring-projects/spring-security-samples/tree/main/servlet/spring-boot/java/oauth2

1、注册客户应用：https://github.com/settings/applications/2536496
![image.png](https://cdn.nlark.com/yuque/0/2024/png/29512941/1712415701743-1f76729e-b450-4687-96b4-1df080ad6531.png#averageHue=%23fefdfc&clientId=u2a7a32db-6914-4&from=paste&height=601&id=u1e0ddbb2&originHeight=751&originWidth=869&originalType=binary&ratio=1.25&rotation=0&showTitle=false&size=62483&status=done&style=none&taskId=uef4f69b6-16a9-4b06-9df6-241e82d861b&title=&width=695.2)

2、资源拥有者访问：http://localhost:8002/

3、User-agent代理授权服务地址：https://github.com/login/oauth/authorize?response_type=code&client_id=6ef17d582ff386565b59&scope=read:user&state=jgs3pygr-1Y7Ke_xhFC4OyVvIOzJ-aeg2H2eUVw4Qjk%3D&redirect_uri=http://localhost:8002/login/oauth2/code/github

创建客户应用端
应用客户端 ---> 授权服务器 重定向地址：https://github.com/login?client_id=6ef17d582ff386565b59&return_to=%2Flogin%2Foauth%2Fauthorize%3Fclient_id%3D6ef17d582ff386565b59%26redirect_uri%3Dhttp%253A%252F%252Flocalhost%253A8002%252Flogin%252Foauth2%252Fcode%252Fgithub%26response_type%3Dcode%26scope%3Dread%253Auser%26state%3DCQEn892ujaqWDcL6q-sqH2UCbfTFrdqprZ7C3emubPo%253D

授权服务器返回的code码：http://localhost:8002/login/oauth2/code/github?code=96c6c1cc74642df32e67&state=jgs3pygr-1Y7Ke_xhFC4OyVvIOzJ-aeg2H2eUVw4Qjk%3D

应用客户端根据Cookie或access_token访问路径：[http://localhost:8002/?continue](http://localhost:8002/?continue)



## 遇到的问题
异常报错：Cannot invoke "org.springframework.security.core.userdetails.UserDetails.getAuthorities()" because "user" is null 

解决方案：@Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return user;  // return null 出现空指针异常 Cannot invoke "org.springframework.security.core.userdetails.UserDetails.getAuthorities()" 
    }

异常报错：There is no PasswordEncoder mapped for the id "null"

解决方案：数据库密文存储格式：{id}encodedPassword



## 参考笔记
"org.springframework.security.core.userdetails.UserDetails.getAuthorities()" because "user" is null 解决方案：
https://www.bilibili.com/read/cv32317029/?jump_opus=1

There is no PasswordEncoder mapped for the id “null“解决方案：
https://blog.csdn.net/xuhuimingc/article/details/108084657

SecurityOAuth2 单点登录和登出：
https://blog.csdn.net/qq_36160730/article/details/105909308/

IAM定义和设计
https://www.woshipm.com/pd/5914930.html
springboot权限处理
https://blog.51cto.com/u_13250/6799248

