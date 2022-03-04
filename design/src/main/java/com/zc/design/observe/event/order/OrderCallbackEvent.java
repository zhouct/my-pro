package com.zc.design.observe.event.order;

import com.zc.design.observe.event.AbstractEvent;
import com.zc.design.observe.event.EventObject;

public class OrderCallbackEvent extends AbstractEvent {

    public OrderCallbackEvent(EventObject eventObject) {
        super(eventObject);
    }

}
