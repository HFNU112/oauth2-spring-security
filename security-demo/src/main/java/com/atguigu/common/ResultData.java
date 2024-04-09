package com.atguigu.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Husp
 * @Date 2024/4/9 21:24
 */
@Data
@Accessors(chain = true)
public class ResultData<T> {

    private String code;

    private String message;

    private T data;

    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ResultCodeEnum.RC200.getCode());
        resultData.setMessage(ResultCodeEnum.RC200.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> fail(String code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMessage(message);

        return resultData;
    }

}
