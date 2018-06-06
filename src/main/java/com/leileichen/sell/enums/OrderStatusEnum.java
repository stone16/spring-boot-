package com.leileichen.sell.enums;

import lombok.Getter;

// 使用enum 在代码里不出现无意义的数字，封装在这里
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISH(1, "完结"),
    CANCEL(2,"取消");

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
