package com.zc.base.tree;

import org.junit.Test;

public class MyTreeSetTest {

    @Test
    public void testAdd(){

        MyTreeSet<Integer> set = new MyTreeSet<>();

        set.add(8);
        set.add(5);
        set.add(15);
        set.add(3);
        set.add(7);
        set.add(10);
        set.add(20);

        System.out.println(set);

    }

}
