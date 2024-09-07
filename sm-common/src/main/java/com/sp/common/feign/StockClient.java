package com.sp.common.feign;

import com.sp.common.entity.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * StockClient
 *
 * @author shipeng
 * @date 2024/9/6 下午5:18
 */
// @FeignClient(name = "sm-stock", fallback = StockClientFallback.class)
@FeignClient(name = "sm-stock")
public interface StockClient {

    @PostMapping("/stock/deduct")
    String deduct(@RequestBody Stock stock);
}
