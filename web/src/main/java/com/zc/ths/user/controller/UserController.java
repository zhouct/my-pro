package com.zc.ths.user.controller;

import com.zc.ths.user.entity.User;
import com.zc.ths.user.service.UserService;
import com.zc.ths.user.vo.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getUserList(UserParam userParam){
        Assert.hasLength(userParam.getUsername(), "用户名不能为空");
        return userService.getUserList(userParam);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public HttpEntity getUserList(@RequestBody User user){
        userService.insert(user);
        return ResponseEntity.ok().build();
    }

}
