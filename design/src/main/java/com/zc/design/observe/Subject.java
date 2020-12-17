package com.zc.design.observe;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observe> observeList = new ArrayList<>();

    private String state;

    public Subject(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public void addObserve(Observe observe){
        observeList.add(observe);
    }

    public void notifyAllObserve(){
        for (Observe observe : observeList) {
            observe.changed();
        }
    }

    public void setState(String state){
        this.state = state;
        System.out.println("状态变化，通知所有观察者");
        notifyAllObserve();
    }


}
