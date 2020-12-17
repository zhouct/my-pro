package com.zc.transaction.service;

import com.zc.transaction.entity.UserBalance;

public interface UserBalanceService {

    void insert(UserBalance userBalance);

    void insertUserAndBalance(String name);

}
