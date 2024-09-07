package com.sp.smaccount.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sp.common.entity.Stock;
import com.sp.common.feign.StockClient;
import com.sp.smaccount.entity.Account;
import com.sp.smaccount.entity.Product;
import com.sp.smaccount.mapper.AccountMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * AccountService
 *
 * @author shipeng
 * @date 2024/9/6 上午11:52
 */
@Service
public class AccountService extends ServiceImpl<AccountMapper, Account> {

    @Autowired
    private StockClient stockClient;


    @GlobalTransactional
    public String buy(Product product) {
        // 判断库存扣减
        Stock stock = new Stock();
        stock.setProductId(product.getProductId());
        stock.setStockNum(product.getNum());
        String response = stockClient.deduct(stock);
        System.out.println("stockClient.deduct => " + response);

        // 从钱包中扣款
        int pay = baseMapper.pay(product.getAccountId(), product.getPrice());
        if (pay == 0) {
            throw new RuntimeException("余额不足！");
        }

        return "购买成功！";
    }





    @PostConstruct
    public void init() {
        System.out.println("添加限流规则，正常是配置在控制台，搭配配置中心持久化");

        List<FlowRule> flowRuleList = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("testSentinelResource");
        rule.setGrade(RuleConstant.FLOW_GRADE_THREAD);
        rule.setCount(2);
        flowRuleList.add(rule);
        FlowRuleManager.loadRules(flowRuleList);
    }

    @SentinelResource(value = "testSentinelResource", fallback = "testSentinelResourceFallback")
    public String testSentinelResource(String arg) {
        return "请求正常！";
    }

    public String testSentinelResourceFallback(String arg) {
        return "请求降级了";
    }
}
