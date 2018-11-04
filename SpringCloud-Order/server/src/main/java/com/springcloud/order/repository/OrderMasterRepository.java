package com.springcloud.order.repository;

import com.springcloud.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/9 23:55
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
