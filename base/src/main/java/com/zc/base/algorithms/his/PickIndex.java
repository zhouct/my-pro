package com.zc.base.algorithms.his;

public class PickIndex {

    private int[] w;

    private int[] counts;

    private int totalCount;

    private int sum;

    public PickIndex(int[] w){
        this.w = w;
        this.counts = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
        }
    }

    public int pickIndex(){
        if(w.length == 1){
            return 0;
        }
        for(int i = 0; i < w.length; i ++){
            if(counts[i] * sum / w[i] > totalCount){
                continue;
            }else {
                totalCount ++;
                counts[i] ++;
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] w = new int[]{1,3};
        PickIndex p = new PickIndex(w);
        System.out.println(p.pickIndex());
        System.out.println(p.pickIndex());
        System.out.println(p.pickIndex());
        System.out.println(p.pickIndex());
        System.out.println(p.pickIndex());
    }

}
