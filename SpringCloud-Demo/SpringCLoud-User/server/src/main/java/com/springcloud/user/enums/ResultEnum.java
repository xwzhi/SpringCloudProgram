package com.springcloud.user.enums;

import lombok.Getter;

/**
 * @Author XuWeiZhi
 * @Description
 * @Date 2018/10/9 23:53
 **/
@Getter
public enum ResultEnum {

    LOGIN_FAIL(1, "登陆失败"),
    ROLE_ERROR(2, "角色权限有误");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
