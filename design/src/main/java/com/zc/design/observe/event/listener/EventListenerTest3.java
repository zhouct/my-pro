package com.zc.design.observe.event.listener;

import com.zc.design.observe.event.Event;
import com.zc.design.observe.event.EventObject;

public class EventListenerTest3 extends AbstractEventListener{

    public EventListenerTest3(int priority) {
        super(priority);
    }

    @Override
    public void onEvent(Event event) {

        System.out.println(String.format("事件监听器3执行， 优先级：%s", getPriority()));

        EventObject eventObject = event.getEventObject();
        System.out.println(String.format("事件监听器3事件对象：%s", eventObject));
    }

}
