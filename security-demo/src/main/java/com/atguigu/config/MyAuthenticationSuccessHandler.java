package com.atguigu.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义一个认证成功后的响应处理器
 * @Author Husp
 * @Date 2024/4/9 23:06
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Map<String, Object> data = new HashMap<>();

        Object principal = authentication.getPrincipal();  // 被认证主体的身份
        Object credentials = authentication.getCredentials();  //证明委托人正确的凭据。这通常是一个密码通常不给前端返回
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities(); //用于指示已授予主体的权限集合
        Object details = authentication.getDetails();  //存储有关身份验证请求的其他详细信息。这些可能是IP地址，证书序列号等通常也不返回给前端

        data.put("principal", principal);
        data.put("credentials", credentials);
        data.put("authorities", authorities);
        data.put("details", details);

        Map<String, Object> result = new HashMap<>();
        result.put("code", HttpStatus.OK.value());
        result.put("message", "认证成功");
        result.put("data", data);
        //将结果集对象转换成json格式的字符串数据
        String json = JSON.toJSONString(result);

        //响应的json的数据返回给前端进行交互处理
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
    }
}
