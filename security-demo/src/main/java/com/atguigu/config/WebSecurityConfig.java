package com.atguigu.config;

import com.alibaba.fastjson2.JSON;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Husp
 * @Date 2024/4/8 0:11
 */
@Configuration
//@EnableWebSecurity  //开启自动装配security
@EnableMethodSecurity  //开启基于方法的所有权限
public class WebSecurityConfig {

    /**
     * security默认的配置：基于表单的身份验证
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //http授权操作配置
        http.authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("/user/list").hasAuthority("USER_LIST")  //拥有USER_LIST的权限的用户可以访问/user/list路径
//                .requestMatchers("/user/add").hasAuthority("USER_ADD")  //拥有USER_ADD的权限的用户可以访问/user/add路径
//                .requestMatchers("/user/delete/{id}").hasAuthority("USER_DELETE")  //拥有USER_DELETE的权限的用户可以访问/user/delete/{id} 路径

                .requestMatchers("/user/**").hasRole("ADMIN")      //拥有ADMIN角色的用户可以访问/user/**路径
//                .requestMatchers("/user/list").hasRole("COMMON")  //拥有COMMON角色的用户可以访问/user/list路径
                .anyRequest()  //认证任何请求
                .authenticated()  //任何经过身份认证通过后的用户允许访问的URL
        );

        //http身份认证表单登录操作配置
        http.formLogin(form -> form
                        .loginPage("/login")  //让用户通过自定义基于表单的登录进行身份验证
                        .permitAll()     // 授权自定义表单通过过滤器链
                        .usernameParameter("username")   // 自定义表单的用户名参数值
                        .passwordParameter("password")   //自定义表单的密码参数值
//                        .failureForwardUrl("/login?error")  // 定义错误返回页面 默认登录 /login 用户错误返回 /login?error
                        .successHandler(new MyAuthenticationSuccessHandler())  // 身份验证成功事件处理对象
                        .failureHandler(new MyAuthenticationFailureHandler())  //身份验证失败事件处理对象
        );
        //允许用户提供基本 HTTP 身份验证支持请求，没有登出操作
//        http
//                .httpBasic(Customizer.withDefaults());

        //http身份注销操作配置
        http.logout(logout -> logout
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(new MyLogoutSuccessHandler())  // 注销身份
        );

        //临时关闭跨站伪造请求
        http.csrf(csrf -> csrf.disable());

        //http验证提交给它的任何身份验证请求的抽象认证处理过滤器
        http.exceptionHandling(exception -> exception
                .authenticationEntryPoint(new MyAuthenticationEntryPoint())
                .accessDeniedHandler((request, response, accessDeniedException) -> {  //定义未被授权访问资源
                    Map<String, Object> result = new HashMap<>();
                    result.put("code", HttpStatus.UNAUTHORIZED.value());
                    result.put("message", "当前资源权限未经授权，无法访问~");

                    //将结果集对象转换成json格式的字符串数据
                    String json = JSON.toJSONString(result);

                    //响应的json的数据返回给前端进行交互处理
                    response.setContentType("application/json;charset=utf-8");
                    response.getWriter().println(json);

                })
        );

        //跨域
        http.cors(Customizer.withDefaults());

        //会话管理策略
        http.sessionManagement(session -> session
                .invalidSessionStrategy(new MyInvalidSessionStrategy())
        );

        return http.build();
    }

    /**
     * 注册基于数据库用户信息的身份认证管理器到spring容器中
     *
     * @return UserDetailsService用户信息对象
     */
//    @Bean
//    public UserDetailsService userDetailsService() {
//        //1.创建了一个基于数据库用户信息的身份认证管理器
//        DBUserDetailsManager manager = new DBUserDetailsManager();
//        return manager;
//    }

    /**
     * 注册基于内存用户信息的身份认证管理器到spring容器中
     * @return UserDetailsService用户信息对象
     */
//    @Bean
//    public UserDetailsService userDetailsService() {
//        //1.创建了一个基于内存用户信息的身份认证管理器
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        //3.使用内存用户的身份认证管理器创建包含用户名、密码、角色、权限信息的自定义用户对象
//        manager.createUser(
//                //2.自定义管理内存中的用户名信息、用户密码信息、用户角色信息、用户权限信息等。优先级：配置类的bean对象 > yml配置的属性
//                User.withDefaultPasswordEncoder().username("husp").password("password").roles("USER").build());
//        return manager;
//    }

}
