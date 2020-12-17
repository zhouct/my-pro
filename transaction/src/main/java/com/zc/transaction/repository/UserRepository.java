package com.zc.transaction.repository;

import com.zc.transaction.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    void addUser(User user);

}
