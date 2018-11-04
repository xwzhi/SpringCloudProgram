package com.springcloud.order.client;

import com.springcloud.order.dataobject.ProductInfo;
import com.springcloud.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName ProductClient
 * @Author XuWeiZhi
 * @Description 服务端数据调用 放在客户端对应的client项目下
 * @Date 2018-10-08 18:20 星期一 My1Program
 * @VERSION 1.0.0
 **/
//@FeignClient(name = "product1")
//@RequestMapping("/product")
public interface ProductClient {

    ////对应项目的路径地址
    //@GetMapping("/msg")
    //String productMsg();
    //
    ////调用项目资源
    //@PostMapping("/listForOrder")
    //public List<ProductInfo> listForOrder(List<String> productIdList);
    //
    ////扣库存
    //@PostMapping("/decreaseStock")
    //public void decreaseStock(List<CartDTO> cartDTOList);

}
