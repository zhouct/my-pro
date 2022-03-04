package com.zc.ths.user.repository;

import com.zc.ths.user.entity.User;
import com.zc.ths.user.vo.UserParam;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String NAMESPACE = "com.zc.ths.user.repository.UserRepositoryImpl";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<User> getUserList(UserParam userParam) {
        return sqlSessionTemplate.selectList(NAMESPACE + ".getUserList", userParam);
    }

    @Override
    public void insert(User user) {
        sqlSessionTemplate.insert(NAMESPACE + ".insert", user);
    }

}
