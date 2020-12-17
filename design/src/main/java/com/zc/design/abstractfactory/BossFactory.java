package com.zc.design.abstractfactory;

import com.zc.design.factorymethod.Person;

public class BossFactory extends PersonFactory{

    @Override
    public Boss produceBoss(int type) {
        if(type == 1){
            return new BossA();
        }else if(type == 2){
            return new BossB();
        }
        return null;
    }

    @Override
    public Teacher produceTeacher(int type) {
        return null;
    }
}
