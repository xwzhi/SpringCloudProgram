package com.springcloud.common.enums;

import lombok.Getter;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/9 23:53
 **/
@Getter
public enum RoleEnum {

    BUYER(1,"买家"),
    SELLER(2,"卖家");

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
