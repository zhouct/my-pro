package com.zc.transaction.service.impl;

import com.zc.transaction.entity.User;
import com.zc.transaction.repository.UserRepository;
import com.zc.transaction.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.stream.StreamSupport;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public void addUser(String name) {
        log.info("[addUser] begin!!!");
        User user = new User();
        user.setName(name);
        userRepository.addUser(user);
        log.info("[addUser] end!!!");
    }
}
