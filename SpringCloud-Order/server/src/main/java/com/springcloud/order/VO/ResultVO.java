package com.springcloud.order.VO;

import lombok.Data;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/9 23:56
 **/
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
