package com.zc.transaction.service.impl;

import com.zc.transaction.entity.User;
import com.zc.transaction.entity.UserBalance;
import com.zc.transaction.repository.UserBalanceRepository;
import com.zc.transaction.service.UserBalanceService;
import com.zc.transaction.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Slf4j
@Service
public class UserBalanceServiceImpl implements UserBalanceService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserBalanceRepository userBalanceRepository;

    @Override
    public void insert(UserBalance userBalance) {
        userBalanceRepository.insert(userBalance);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertUserAndBalance(String name) {
        userService.addUser(name);

        UserBalance balance = new UserBalance();
        balance.setName(name);
        balance.setBalance(new BigDecimal(1000));
        userBalanceRepository.insert(balance);
    }

}
