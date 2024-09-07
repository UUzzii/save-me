package com.sp.smstock.controller;

import com.sp.common.entity.Stock;
import com.sp.smstock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * StockController
 *
 * @author shipeng
 * @date 2024/9/6 上午11:53
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;


    /**
     * 扣减库存
     * @param stock
     * @return
     */
    @PostMapping("/deduct")
    public String deduct(@RequestBody Stock stock) {
        return stockService.deduct(stock);
    }
}
