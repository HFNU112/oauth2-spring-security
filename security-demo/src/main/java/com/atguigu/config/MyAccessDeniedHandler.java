package com.atguigu.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义请求未被授权访问的资源配置处理事件
 * @Author Husp
 * @Date 2024/4/14 17:51
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        String message = accessDeniedException.getLocalizedMessage();

        Map<String, Object> result = new HashMap<>();
        result.put("code", HttpStatus.UNAUTHORIZED.value());
        result.put("message", "当前资源权限未经授权，无法访问~");

        //将结果集对象转换成json格式的字符串数据
        String json = JSON.toJSONString(result);

        //响应的json的数据返回给前端进行交互处理
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);

    }
}
