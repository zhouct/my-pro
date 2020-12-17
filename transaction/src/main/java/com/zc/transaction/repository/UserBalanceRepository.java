package com.zc.transaction.repository;

import com.zc.transaction.entity.UserBalance;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBalanceRepository {

    void insert(UserBalance userBalance);

}
