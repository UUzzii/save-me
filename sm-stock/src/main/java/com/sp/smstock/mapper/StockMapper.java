package com.sp.smstock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sp.common.entity.Stock;

/**
 * StockMapper
 *
 * @author shipeng
 * @date 2024/9/6 上午11:04
 */
public interface StockMapper extends BaseMapper<Stock> {

    /**
     * 扣减库存
     *
     * @param stock
     * @return
     */
    int deduct(Stock stock);
}
