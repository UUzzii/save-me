package com.sp.smstock.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sp.common.entity.Stock;
import com.sp.smstock.mapper.StockMapper;
import org.springframework.stereotype.Service;

/**
 * StockService
 *
 * @author shipeng
 * @date 2024/9/6 上午11:52
 */
@Service
public class StockService extends ServiceImpl<StockMapper, Stock> {


    public String deduct(Stock stock) {
        int i = baseMapper.deduct(stock);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (i == 0) {
            throw new RuntimeException("扣减失败，库存不足！");
        }
        return "扣减成功";
    }
}
