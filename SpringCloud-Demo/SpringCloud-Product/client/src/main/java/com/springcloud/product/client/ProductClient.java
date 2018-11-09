package com.springcloud.product.client;

import com.spring.product.common.DecreaseStockInput;
import com.spring.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author XuWeiZhi
 * @Description 服务端熔断和应用通信
 * @Date 2018/10/9 23:48
 **/
@FeignClient(name = "product", fallback = ProductClient.ProductClientBack.class)
public interface ProductClient {

    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

    /*因为order引入了依赖，所以需要对order应用配置包扫描,方法错误，进行熔断调用下面的方法*/
    @Component
    public static class ProductClientBack implements ProductClient {

        @Override
        public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
            return null;
        }

        @Override
        public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

        }
    }
}
