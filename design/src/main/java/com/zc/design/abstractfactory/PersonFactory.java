package com.zc.design.abstractfactory;

public abstract class PersonFactory {

    public abstract Boss produceBoss(int type);

    public abstract Teacher produceTeacher(int type);

}
