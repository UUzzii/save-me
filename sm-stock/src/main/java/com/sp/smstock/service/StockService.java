package com.sp.smstock.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sp.common.entity.Order;
import com.sp.common.entity.Stock;
import com.sp.common.feign.OrderClient;
import com.sp.smstock.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * StockService
 *
 * @author shipeng
 * @date 2024/9/6 上午11:52
 */
@Service
public class StockService extends ServiceImpl<StockMapper, Stock> {

    @Autowired
    private OrderClient orderClient;


    @Transactional(rollbackFor = Exception.class)
    public String deduct(Stock stock) {
        int i = baseMapper.deduct(stock);

        if (i == 0 || stock.getStockNum() == 22) {
            throw new RuntimeException("扣减失败，库存不足！");
        }

        Order order = new Order();
        order.setAccountId(1);
        order.setProductId(stock.getProductId());
        order.setProductNum(stock.getStockNum());
        String response = orderClient.create(order);
        System.out.println(response);

        return "扣减成功";
    }
}
