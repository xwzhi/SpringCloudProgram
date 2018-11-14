package com.springcloud.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.order.VO.ResultVO;
import com.springcloud.order.converter.OrderForm2OrderDTOConverter;
import com.springcloud.order.dto.OrderDTO;
import com.springcloud.order.enums.ResultEnum;
import com.springcloud.order.exception.OrderException;
import com.springcloud.order.form.OrderForm;
import com.springcloud.order.service.OrderService;
import com.springcloud.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author XuWeiZhi
 * @Description
 * @Date 2018/10/10 11:29
 **/
@RestController
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "defaultFallback")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1. 参数检验
     * 2. 查询商品信息(调用商品服务)
     * 3. 计算总价
     * 4. 扣库存(调用商品服务)
     * 5. 订单入库
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        // orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }

    @PostMapping("/finish")
    public ResultVO<OrderDTO> finish(@RequestParam("orderId") String orderId) {
        return ResultVOUtil.success(orderService.finish(orderId));
    }

    @HystrixCommand
    @GetMapping("/getList")
    public String getList(@RequestParam("number") Integer number) {
        if (number % 2 == 0) {
            return "success";
        }
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8081/product/listForOrder", Arrays.asList("164103465734242707"), String.class);
    }

    @GetMapping("/index")
    public String getIndex(){
        return "Haha";
    }
    @GetMapping("/index3")
    public String getIndex3(){
        return "Haha";
    }

    @HystrixCommand
    @GetMapping("/index2")
    public String getIndex2(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://127.0.0.1:8081/product/listForOrder", Arrays.asList("164103465734242707"), String.class);
        System.out.println("我进入方法了");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Haha";
    }

    @GetMapping("/index1")
    public String getIndex1(){
        return "Haha";
    }

    public String defaultFallback() {
        return "这是Hystrix默认的一个服务降级回调方法!适用于全局回调方法！";
    }

}
