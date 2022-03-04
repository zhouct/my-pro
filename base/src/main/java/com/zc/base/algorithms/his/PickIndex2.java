package com.zc.base.algorithms.his;

import java.util.Random;

public class PickIndex2 {

    private int[] w;

    private int[] pre;

    private Random random = new Random();


    public PickIndex2(int[] w){
        this.w = w;
        this.pre = new int[w.length+1];
        pre[0] = 0;
        for (int i = 1; i <= w.length; i++) {
            pre[i] = pre[i-1] + w[i-1];
        }
    }

    public int pickIndex(){
        int num = random.nextInt(pre[pre.length - 1]) + 1;
        for (int i = 0; i < pre.length; i++) {
            if(num <= pre[i]){
                return i - 1;
            }
        }
        return pre.length - 2;
    }

    public static void main(String[] args) {
        int[] w = new int[]{1,3};
        PickIndex2 p = new PickIndex2(w);
        System.out.println(p.pickIndex());
        System.out.println(p.pickIndex());
        System.out.println(p.pickIndex());
        System.out.println(p.pickIndex());
        System.out.println(p.pickIndex());
    }

}
