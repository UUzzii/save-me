package com.sp.smaccount.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Product
 *
 * @author shipeng
 * @date 2024/9/6 上午11:05
 */
@Data
public class Product {

    private Integer accountId;

    private Integer productId;

    private Integer num;

    private BigDecimal price;
}
