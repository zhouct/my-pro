package com.zc.transaction.entity;

import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;

@Data
public class User {

    private Integer id;

    private String name;

    private Long balance;

}
