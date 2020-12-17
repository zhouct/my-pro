package com.zc.design.abstractfactory;

public class FactoryProvider {

    public static PersonFactory produce(int type){
        if(type == 1){
            return new BossFactory();
        }else if(type == 2){
            return new TeacherFactory();
        }
        return null;
    }
}
