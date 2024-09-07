package com.sp.smaccount.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sp.common.entity.Stock;
import com.sp.common.feign.StockClient;
import com.sp.smaccount.entity.Account;
import com.sp.smaccount.entity.Product;
import com.sp.smaccount.mapper.AccountMapper;
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


    public String buy(Product product) {
        Stock stock = new Stock();
        stock.setProductId(product.getProductId());
        stock.setStockNum(product.getNum());

        String response = stockClient.deduct(stock);
        System.out.println("stockClient.deduct => " + response);

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
