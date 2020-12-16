package com.zc.aop.demo;

import com.zc.aop.service.OrderService;
import com.zc.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopDemo {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-aop.xml");

//        UserService proxyUserService = (UserService) ctx.getBean("proxyUserService");
//        proxyUserService.createUser("zhang", "san", 30);
//        proxyUserService.queryUser();

        UserService userService = (UserService) ctx.getBean("userService");
        userService.createUser("zhang", "san", 30);
        userService.queryUser();

        OrderService orderService = (OrderService) ctx.getBean("orderService");
        orderService.createOrder("zhangsan", "产品A");
        orderService.queryOrder("zhangsan");

    }

}
