package com.sp.smaccount.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sp.smaccount.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * AccountMapper
 *
 * @author shipeng
 * @date 2024/9/6 上午11:04
 */
public interface AccountMapper extends BaseMapper<Account> {

    int pay(@Param("id") Integer id, @Param("money") BigDecimal money);
}
