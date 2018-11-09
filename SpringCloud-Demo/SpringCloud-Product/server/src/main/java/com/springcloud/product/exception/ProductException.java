package com.springcloud.product.exception;

import com.springcloud.product.enums.ResultEnum;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/9 23:42
 **/
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
