package com.zc.design.observe;

public class ObserveDemo {

    public static void main(String[] args) {

        Subject subject = new Subject("ok");

        Observe observeA = new ObserveA(subject);
        Observe observeB = new ObserveB(subject);

        subject.setState("failed");
    }

}
