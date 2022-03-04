package com.zc.design.observe.event.listener;

import com.zc.design.observe.event.Event;
import com.zc.design.observe.event.EventObject;

public class EventListenerTest1 extends AbstractEventListener{

    public EventListenerTest1(int priority) {
        super(priority);
    }

    @Override
    public void onEvent(Event event) {

        System.out.println(String.format("事件监听器1执行， 优先级：%s", getPriority()));

        EventObject eventObject = event.getEventObject();
        System.out.println(String.format("事件监听器1事件对象：%s", eventObject));
    }

}
