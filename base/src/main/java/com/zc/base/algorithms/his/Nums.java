package com.zc.base.algorithms.his;

public class Nums {

    public static void main(String[] args) {

        int n = 16;
        int count = find1Count(n);
        System.out.println(count);
    }

    private static int find1Count(int n) {

        int count = 0;
        for(int i = 0; i <= n; i ++){
            char[] chars = String.valueOf(i).toCharArray();
            for (char num :chars){
                if(Integer.parseInt(String.valueOf(num)) == 1){
                    count ++;
                }
            }
        }

        return count;
    }

}
