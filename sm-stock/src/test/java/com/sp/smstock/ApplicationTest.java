package com.sp.smstock;

import com.sp.common.entity.Stock;
import com.sp.smstock.mapper.StockMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTest {

    @Autowired
    private StockMapper stockMapper;

    @Test
    void contextLoads() {
        Stock stock = new Stock();
        stock.setProductId(1001);
        stock.setStockNum(68);
        stockMapper.insert(stock);

        List<Stock> stockList = stockMapper.selectList(null);
        System.out.println(stockList);
    }

}
