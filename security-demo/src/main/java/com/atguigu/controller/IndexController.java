package com.atguigu.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Husp
 * @Date 2024/4/7 21:42
 */
@RestController
//@Controller
public class IndexController {

    /**
     * servlet的认证身份核心模型信息
     * @RestController映射到index.html超链接不显示
     * @return
     */
    @GetMapping("/")
    public Map<String, Object> index(){

        //获取有关经过身份验证的主体的信息 SecurityContextHolder
        SecurityContext context = SecurityContextHolder.getContext();
        //经过身份认证的用户
        Authentication authentication = context.getAuthentication();
        String username = authentication.getName();
        //获取用户信息
        Object principal = authentication.getPrincipal();
        //用户被授予的权限
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Object credentials = authentication.getCredentials();  //脱敏凭证
        Object details = authentication.getDetails();

        Map<String, Object> result = new HashMap<>();
        result.put("username", username);
        result.put("principal", principal);
        result.put("authorities", authorities);
        result.put("credentials", credentials);
        result.put("details", details);

        return result;
    }

    /**
     * 默认security 用户:user 密码: 控制台随机
     * @RestController映射到index.html超链接不显示
     * @return
     */
//    @GetMapping("/")
//    public String index(){
//        return "index";
//    }

}
