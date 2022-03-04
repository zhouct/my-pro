package com.zc.design.observe.event;

import com.zc.design.observe.event.listener.AbstractEventListener;
import com.zc.design.observe.event.listener.EventListenerTest1;
import com.zc.design.observe.event.listener.EventListenerTest2;
import com.zc.design.observe.event.listener.EventListenerTest3;
import com.zc.design.observe.event.order.Order;
import com.zc.design.observe.event.order.OrderCallbackEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestOrderEvent {

    public static void main(String[] args) {

        /**
         * 定义订单回调事件
         */
        Order order = new Order("ZC" + System.currentTimeMillis());
        EventObject eventObject = new EventObject(order);

        OrderCallbackEvent orderCallbackEvent = new OrderCallbackEvent(eventObject);

        /**
         * 定义监听器，观察者
         */
        List<AbstractEventListener> listeners = new ArrayList<>(3);

        listeners.add(new EventListenerTest1(2));
        listeners.add(new EventListenerTest2(1));
        listeners.add(new EventListenerTest3(3));

        /**
         * 监听优先级
         */
        listeners = listeners.stream()
                .sorted(Comparator.comparing(AbstractEventListener :: getPriority))
                .collect(Collectors.toList());

        /**
         * 定义广播器
         */
        EventMultiCaster caster = new EventMultiCaster(listeners);

        /**
         * 广播订单回调事件
         */
        caster.casterEvent(orderCallbackEvent);

    }

}
