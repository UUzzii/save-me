package com.sp.smaccount.entity;

import lombok.Data;

/**
 * Stock
 *
 * @author shipeng
 * @date 2024/9/6 上午11:05
 */
@Data
public class Account {

    private Integer id;

    private Integer productId;

    /** 仓库名称 */
    private String stockName;

    /** 仓库库存数量 */
    private Integer stockNum;
}
