package com.springcloud.order.enums;

import lombok.Getter;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/9 23:53
 **/
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
