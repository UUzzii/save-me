package com.sp.smorder.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sp.common.entity.Order;
import com.sp.smorder.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * OrderService
 *
 * @author shipeng
 * @date 2024/9/6 上午11:52
 */
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {


    public String create(Order order) {
        order.setCode(System.currentTimeMillis()+"");
        order.setCreateTime(LocalDateTime.now());
        baseMapper.insert(order);

        if (order.getProductNum() == 21) {
            throw new RuntimeException("未知错误，订单创建失败！");
        }

        return "订单创建成功：" + order.getCode();
    }
}
