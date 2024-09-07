package com.sp.common.feign;

import com.sp.common.entity.Stock;

/**
 * StockClientFallback
 *
 * @author shipeng
 * @date 2024/9/6 下午7:31
 */
public class StockClientFallback implements StockClient {

    @Override
    public String deduct(Stock stock) {
        System.out.println("降级了！");
        return "deduct降級了！";
    }
}
