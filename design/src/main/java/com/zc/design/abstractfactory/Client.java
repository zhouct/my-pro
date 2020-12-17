package com.zc.design.abstractfactory;

import com.zc.design.factorymethod.Person;
import com.zc.design.factorymethod.PersonProvider;

public class Client {

    public static void main(String[] args) {

        PersonFactory factory = FactoryProvider.produce(1);
        Boss boss = factory.produceBoss(1);
        boss.show();

        factory = FactoryProvider.produce(2);
        Teacher teacher = factory.produceTeacher(2);
        teacher.teach();

    }

}
