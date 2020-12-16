package com.zc.aop.service;


import com.zc.aop.entity.Order;

public interface OrderService {

    Order createOrder(String username, String product);

    Order queryOrder(String username);

}
