package com.leileichen.sell.VO;


import lombok.Data;

// HTTP 请求返回的最外层对象

@Data
public class ResultVO<T> {

//    错误码
    private Integer code;

//    提示信息
    private String msg;

//    T 表示是一个泛型 ， 里面是返回的具体内容
    private T data;
}
