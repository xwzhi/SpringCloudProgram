package com.springcloud.product.vo;

import lombok.Data;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/9 23:41
 **/
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
