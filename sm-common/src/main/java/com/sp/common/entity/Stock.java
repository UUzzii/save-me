package com.sp.common.entity;

import lombok.Data;

/**
 * Stock
 *
 * @author shipeng
 * @date 2024/9/6 上午11:05
 */
@Data
public class Stock {

    private Integer id;

    private Integer productId;

    /** 仓库库存数量 */
    private Integer stockNum;
}
