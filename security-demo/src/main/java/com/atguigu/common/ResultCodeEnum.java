package com.atguigu.common;

import lombok.Getter;

/**
 * @Author Husp
 * @Date 2024/4/9 21:25
 */
@Getter
public enum ResultCodeEnum {

    //1、举值
    RC200("200", "操作成功"),

    RC201("201", "服务开启降级保护，请稍后保护"),

    RC203("203","系统规则不满足要求,请稍后再试!"),

    RC204("204","授权规则不通过,请稍后再试!"),

    RC401("401","匿名用户访问无权限资源时的异常"),

    RC403("403","无访问权限,请联系管理员授予权限"),

    RC404("404","找不到的异常"),

    RC500("500","系统服务器异常，请稍后重试"),

    USERNAME_OR_PASSWORD_ERROR("1002","用户名或密码错误"),

    BUSINESS_ERROR("1004","业务逻辑异常");

    //2、构造
    private final String code;  // 自定义响应码

    private final String message;   // 描述

    ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    //3、遍历静态方法
    public static ResultCodeEnum getResultCodeEnum(String code){
        for (ResultCodeEnum value : ResultCodeEnum.values()) {
            if (value.getCode().equalsIgnoreCase(code)) {
                return value;
            }
        }
        return null;
    }


}
