package com.zc.design.factorymethod;

public class Client {

    public static void main(String[] args) {

        PersonProvider provider = new BossFactory();
        Person person = provider.produce();
        person.show();

        provider = new TeacherFactory();
        person = provider.produce();
        person.show();

    }

}
