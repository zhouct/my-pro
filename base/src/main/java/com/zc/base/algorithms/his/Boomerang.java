package com.zc.base.algorithms.his;

import java.util.HashMap;
import java.util.Map;

public class Boomerang {

    public static void main(String[] args) {
        Boomerang boomerang = new Boomerang();
        int[][] points = {{0,0},{1,0},{2,0}};
        System.out.println(boomerang.numberOfBoomerangs(points));
    }

    public int numberOfBoomerangs(int[][] points) {

        int sum = 0;
        for (int[] p1 : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] p2 : points) {
                int s = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);

                map.put(s, (map.containsKey(s) ? map.get(s) : 0 ) + 1);
            }
            for (Integer value : map.values()) {
                sum += value * (value - 1);
            }
        }

        return sum;
    }

}
