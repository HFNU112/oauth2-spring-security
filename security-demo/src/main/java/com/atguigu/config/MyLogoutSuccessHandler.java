package com.atguigu.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义注销身份配置事件处理器
 * @Author Husp
 * @Date 2024/4/9 23:28
 */
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Map<String, Object> result = new HashMap<>();
        result.put("code", HttpStatus.OK.value());
        result.put("message", "注销成功");

        //将结果集对象转换成json格式的字符串数据
        String json = JSON.toJSONString(result);

        //响应的json的数据返回给前端进行交互处理
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
    }
}
