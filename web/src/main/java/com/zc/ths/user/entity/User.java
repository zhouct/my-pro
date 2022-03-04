package com.zc.ths.user.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long id;

    private String username;

    private String accountName;

    private String password;

    private String name;

    private Date birthday;

    private Float age;

    private Integer sex;

}
