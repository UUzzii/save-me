package com.sp.smorder.controller;

import com.sp.smorder.entity.Order;
import com.sp.smorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController
 *
 * @author shipeng
 * @date 2024/9/6 上午11:53
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    /**
     * 创建订单
     * @param order
     * @return
     */
    @PostMapping("/create")
    public String create(@RequestBody Order order) {
        return orderService.create(order);
    }
}
