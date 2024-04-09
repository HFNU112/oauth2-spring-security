package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author Husp
 * @Date 2024/4/8 0:11
 */
@Configuration
public class WebSecurityConfig {

    /**
     * 注册基于数据库用户信息的身份认证管理器到spring容器中
     *
     * @return UserDetailsService用户信息对象
     */
    @Bean
    public UserDetailsService userDetailsService() {
        //1.创建了一个基于数据库用户信息的身份认证管理器
        DBUserDetailsManager manager = new DBUserDetailsManager();
        return manager;
    }

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
