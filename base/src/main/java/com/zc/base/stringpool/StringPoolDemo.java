package com.zc.base.stringpool;

import java.awt.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class StringPoolDemo {

    public static final WeakHashMap<String, WeakReference<String>> pool = new WeakHashMap<>(1024);

    public static void main(String[] args) {

        test(1000 * 1000 * 1000);

    }

    public static String myIntern(final String str){
        final WeakReference<String> cached = pool.get(str);
        if(cached != null){
            String cachedStr = cached.get();
            if(cachedStr != null){
                return cachedStr;
            }
        }
        pool.put(str, new WeakReference<>(str));
        return str;
    }

    public static void test(int count){
        final List<String> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; ++i) {

            list.add(String.valueOf(i).intern());

            if (i % 200000 == 0) {
                System.out.println(i + 200000 + "; time = " + (System.currentTimeMillis() - start) / 1000.0 + " sec");
                start = System.currentTimeMillis();
            }
        }
        System.out.println("Total length = " + list.size());
    }

}
