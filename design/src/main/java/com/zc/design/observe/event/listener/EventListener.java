package com.zc.design.observe.event.listener;

import com.zc.design.observe.event.Event;
import com.zc.design.observe.event.EventObject;

public interface EventListener {

    /**
     * 事件触发后调用
     */
    void onEvent(Event event);

}
