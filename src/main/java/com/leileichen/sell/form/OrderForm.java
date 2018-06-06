package com.leileichen.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * form整个package就是用来进行表单验证的
 */
@Data
public class OrderForm {

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;
}
