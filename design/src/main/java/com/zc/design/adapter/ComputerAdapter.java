package com.zc.design.adapter;

public class ComputerAdapter extends HomeElect implements Computer{
    @Override
    public void user15V() {
        System.out.println("可以使用15V电压");
    }
}
