package com.zc.design.observe.event.order;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private String orderId;

    private Date creationDate;

    public Order(String orderId){
        this.orderId = orderId;
        creationDate = new Date();
    }

}
