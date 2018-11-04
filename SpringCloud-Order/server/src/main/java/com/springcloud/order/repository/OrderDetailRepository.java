package com.springcloud.order.repository;

import com.springcloud.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/9 23:55
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
