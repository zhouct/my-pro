package com.zc.transaction.service.impl;

import com.zc.transaction.BaseTest;
import com.zc.transaction.service.UserBalanceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class UserBalanceServiceImplTest extends BaseTest {

    @Autowired
    private UserBalanceService userBalanceService;

    @Test
    public void insert() {
    }

    @Test
    public void insertUserAndBalance() {

        String name = "王雷";
        userBalanceService.insertUserAndBalance(name);

    }

}