package com.zc.ths.user.service;

import com.zc.ths.user.entity.User;
import com.zc.ths.user.vo.UserParam;

import java.util.List;

public interface UserService {

    List<User> getUserList(UserParam userParam);

}
