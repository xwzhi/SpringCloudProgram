package com.springcloud.order.service;

import com.springcloud.order.dto.OrderDTO;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/10 0:00
 **/
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
