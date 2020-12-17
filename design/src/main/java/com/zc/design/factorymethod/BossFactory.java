package com.zc.design.factorymethod;

public class BossFactory implements PersonProvider {
    @Override
    public Person produce() {
        return new Boss();
    }
}
