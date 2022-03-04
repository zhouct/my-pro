package com.zc.design.observe.event;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class EventObject {

    private Object data;

    public EventObject(Object data){
        this.data = data;
    }

}
