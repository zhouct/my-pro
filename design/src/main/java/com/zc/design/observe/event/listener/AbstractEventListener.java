package com.zc.design.observe.event.listener;


import com.zc.design.observe.event.Event;

public abstract class AbstractEventListener implements EventListener {

    private int priority;           // 监听优先级

    public int getPriority(){
        return this.priority;
    }

    public AbstractEventListener(int priority){
        this.priority = priority;
    }

    public abstract void onEvent(Event event);

}
