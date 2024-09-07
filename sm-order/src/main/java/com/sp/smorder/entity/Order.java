package com.sp.smorder.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Order
 *
 * @author shipeng
 * @date 2024/9/6 上午11:05
 */
@Data
public class Order {

    private Integer id;

    private String code;

    private Integer accountId;

    private Integer productId;

    /** 商品数量 */
    private Integer productNum;

    private LocalDateTime createTime;
}
