package com.zc.transaction.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserBalance {

    private Integer id;

    private String name;

    private BigDecimal balance;

}
