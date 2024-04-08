package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author: shunpeng.hu
 * @date: 2024/4/8 14:06
 */
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //http授权操作配置
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/").permitAll()
                //.requestMatchers("/user/add").hasAuthority("USER_ADD")  // 配置请求的权限路径
                //.requestMatchers("/user/**").hasRole("ADMIN")  // 配置请求资源的角色信息
                .anyRequest() //认证任何请求
                .authenticated() //任何经过身份认证通过后的用户允许访问的URL
        );

        //http身份注销操作清除cookie
        http.logout(logout -> logout
                .logoutSuccessHandler(new ClearCookieLogoutSuccessHandler())  //清除cookie
                .invalidateHttpSession(true)    //注销时使HttpSession无效
                .clearAuthentication(true)    //清除身份验证
                .permitAll()
        );

        return http.build();
    }
}
