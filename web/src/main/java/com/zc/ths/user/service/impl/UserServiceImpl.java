package com.zc.ths.user.service.impl;

import com.zc.ths.user.entity.User;
import com.zc.ths.user.repository.UserRepository;
import com.zc.ths.user.service.UserService;
import com.zc.ths.user.vo.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList(UserParam userParam) {
        return userRepository.getUserList(userParam);
    }

}
