package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Husp
 * @Date 2024/4/7 21:44
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
