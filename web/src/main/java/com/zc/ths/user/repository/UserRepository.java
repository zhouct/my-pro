package com.zc.ths.user.repository;

import com.zc.ths.user.entity.User;
import com.zc.ths.user.vo.UserParam;

import java.util.List;

public interface UserRepository {

    List<User> getUserList(UserParam userParam);

}
