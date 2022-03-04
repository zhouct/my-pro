package com.zc.design.observe.event;

import com.zc.design.observe.event.listener.AbstractEventListener;

import java.util.List;

public class EventMultiCaster {

    private List<AbstractEventListener> eventListeners;

    public EventMultiCaster(List<AbstractEventListener> eventListeners){
        this.eventListeners = eventListeners;
    }

    public void casterEvent(Event event){
        for (AbstractEventListener eventListener : eventListeners) {
            eventListener.onEvent(event);
        }
    }

}
