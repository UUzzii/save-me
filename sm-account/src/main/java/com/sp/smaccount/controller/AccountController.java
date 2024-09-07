package com.sp.smaccount.controller;

import com.sp.smaccount.entity.Product;
import com.sp.smaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AccountController
 *
 * @author shipeng
 * @date 2024/9/6 上午11:53
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    /**
     * 购买商品
     * @param product
     * @return
     */
    @PostMapping("/buy")
    public String buy(@RequestBody Product product) {
        return accountService.buy(product);
    }
}
