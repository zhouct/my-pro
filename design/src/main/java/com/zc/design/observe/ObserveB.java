package com.zc.design.observe;

public class ObserveB extends Observe {

    public ObserveB(Subject subject) {
        super(subject);
        subject.addObserve(this);
        System.out.println("观察者B加入监听消息");
    }

    @Override
    public void changed() {
        System.out.println("观察者B收到消息");
    }
}
