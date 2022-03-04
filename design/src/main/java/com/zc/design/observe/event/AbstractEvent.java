package com.zc.design.observe.event;

public class AbstractEvent implements Event {

    private EventObject eventObject;

    public AbstractEvent(EventObject eventObject){
        setEventObject(eventObject);
    }

    @Override
    public EventObject getEventObject() {
        return this.eventObject;
    }

    @Override
    public void setEventObject(EventObject eventObject) {
        this.eventObject = eventObject;
    }
}
