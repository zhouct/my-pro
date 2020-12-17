package com.zc.design.factorymethod;

public class TeacherFactory implements PersonProvider{

    @Override
    public Person produce() {
        return new Teacher();
    }
}
