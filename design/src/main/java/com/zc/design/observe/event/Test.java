package com.zc.design.observe.event;

public class Test {

    public static void main(String[] args) {

        String a = "广发中证****有限公司";
        String keyword = "中证**";

        a.replaceAll(keyword, String.format("<%s>", keyword));

        System.out.println(a);

    }

}
