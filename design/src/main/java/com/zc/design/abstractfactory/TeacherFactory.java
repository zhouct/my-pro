package com.zc.design.abstractfactory;

import com.zc.design.factorymethod.Person;

public class TeacherFactory extends PersonFactory{

    @Override
    public Boss produceBoss(int type) {
        return null;
    }

    @Override
    public Teacher produceTeacher(int type) {
        if(type == 1){
            return new TeachA();
        }else if(type == 2){
            return new TeachB();
        }
        return null;
    }
}
