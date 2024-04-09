package com.atguigu.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义认证失败身份管理器
 * @Author Husp
 * @Date 2024/4/9 23:09
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) throws IOException, ServletException {

        String message = authenticationException.getLocalizedMessage();

        Map<String, Object> result = new HashMap<>();
        result.put("code", HttpStatus.UNAUTHORIZED.value());
        result.put("message", message);

        //将结果集对象转换成json格式的字符串数据
        String json = JSON.toJSONString(result);

        //响应的json的数据返回给前端进行交互处理
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);

    }
}
