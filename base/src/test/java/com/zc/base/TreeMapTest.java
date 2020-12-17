package com.zc.base;

import org.junit.Test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class TreeMapTest {

    @Test
    public void testPut(){

        Map<Integer, String> map = new TreeMap<>();
        for(int i = 0; i < 20; i ++){
            int num = ThreadLocalRandom.current().nextInt(100);
            map.put(num, "value_" + num);
        }

        System.out.println(map);

        System.out.println("==========================================================");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

}
