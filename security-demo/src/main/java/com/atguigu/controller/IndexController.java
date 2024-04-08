package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Husp
 * @Date 2024/4/7 21:42
 */
//@RestController
@Controller
public class IndexController {

    /**
     * 默认security 用户:user 密码: 控制台随机
     * @RestController映射到index.html超链接不显示
     * @return
     */
//    @GetMapping("/")
//    public Map<String, Object> index(){
//
//        //获取有关经过身份验证的主体的信息
//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication = context.getAuthentication();
//        String username = authentication.getName();
//        Object principal = authentication.getPrincipal();
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        Object credentials = authentication.getCredentials();  //脱敏凭证
//        Object details = authentication.getDetails();
//
//        Map<String, Object> result = new HashMap<>();
//        result.put("username", username);
//        result.put("principal", principal);
//        result.put("authorities", authorities);
//        result.put("credentials", credentials);
//        result.put("details", details);
//
//        return result;
//    }

    /**
     * 默认security 用户:user 密码: 控制台随机
     * @RestController映射到index.html超链接不显示
     * @return
     */
    @GetMapping("/")
    public String index(){
        return "index";
    }

}
