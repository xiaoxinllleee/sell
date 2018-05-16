package com.yaoyao.sell.vo;

import lombok.Data;

@Data
public class ResultVo<T> {
    //错误码
    private Integer code;

    private String msg;

    //返回的具体内容
    private T data;
}
