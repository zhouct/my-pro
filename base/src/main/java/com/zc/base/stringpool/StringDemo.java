package com.zc.base.stringpool;

import java.util.ArrayList;
import java.util.List;

public class StringDemo {

    public static void main(String[] args) {

        test(4000000);

    }

    private static void test(int count) {

        final List<String> list = new ArrayList<>(1024);
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i ++){
            final String str = "string------------------------------------------------------" + "string_" + i;
            list.add(str.intern());

            if (i % 200000 == 0) {
                System.out.println(i + 200000 + "; time = " + (System.currentTimeMillis() - start) / 1000.0 + " sec");
                start = System.currentTimeMillis();
            }
        }

        System.out.println("Total length = " + list.size());

    }

}
