package com.springcloud.order.exception;

import com.springcloud.order.enums.ResultEnum;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/9 23:53
 **/
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
