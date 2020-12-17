package com.zc.design.observe;

public class ObserveA extends Observe {

    public ObserveA(Subject subject) {
        super(subject);
        subject.addObserve(this);
        System.out.println("观察者A加入监听消息");
    }

    @Override
    public void changed() {
        System.out.println("观察者A收到消息");
    }
}
