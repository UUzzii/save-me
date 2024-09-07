package com.sp.common.feign;

import com.sp.common.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * OrderClient
 *
 * @author shipeng
 * @date 2024/9/7 下午11:01
 */
@FeignClient(name = "sm-order")
public interface OrderClient {

    @PostMapping("/order/create")
    String create(@RequestBody Order order);
}
