package com.zc.aop.service;

import com.zc.aop.entity.User;

public interface UserService {

    User createUser(String firstName, String lastName, int age);

    User queryUser();

}

