package com.springcloud.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.spring.product.common.ProductInfoOutput;
import com.springcloud.order.utils.JsonUtil;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName ProductInfoMessage
 * @Author XuWeiZhi
 * @Description
 * @Date 2018-10-15 00:39 星期一 Worklearn
 * @VERSION 1.0.0
 **/
@Component
public class ProductInfoMessage {

    private static final String PRODUCT_STOCK_TEMPLATE = "procudt_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * @Author XuWeiZhi
     * @Description 产品转换
     * @Date 2018/10/11 22:13
     **/
    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void productInfo(String message) {
        System.out.println(message);
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>) JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfoOutput>>() {});
        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            String key = String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput.getProductId());
            String value = String.valueOf(productInfoOutput.getProductStock());
            stringRedisTemplate.opsForValue().set(key, value);
        }
    }

}
