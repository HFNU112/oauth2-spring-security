package com.atguigu.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.session.InvalidSessionStrategy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义无效会话策略事件处理器
 * @Author Husp
 * @Date 2024/4/12 22:36
 */
public class MyInvalidSessionStrategy implements InvalidSessionStrategy {

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, Object> result = new HashMap<>();
        result.put("code", HttpStatus.REQUEST_TIMEOUT.value());
        result.put("message", "请求会话超时");

        //将结果集对象转换成json格式的字符串数据
        String json = JSON.toJSONString(result);

        //响应的json的数据返回给前端进行交互处理
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
    }
}
