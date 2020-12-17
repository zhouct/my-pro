package com.zc.design.decorate;

public class SugarDecorate extends Food {

    private Food food;

    public SugarDecorate(Food food){
        this.food = food;
    }

    @Override
    void describe() {
        food.describe();
        System.out.println("加点糖");
    }

}
