package com.zc.base.algorithms.his;

public class ReverseVowels {

    public static void main(String[] args) {

        System.out.println(doReverse("leetcode"));

    }

    public static String doReverse(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        String tars = "aeiouAEIOU";
        int startCount = 0;
        int endCount = 0;
        while(start <= end){
            if(tars.indexOf(arr[start]) != -1 && startCount == 0){
                startCount ++;
            }
            if(startCount == 0){
                start ++;
            }
            if(tars.indexOf(arr[end]) != -1 && endCount == 0){
                endCount ++;
            }
            if(endCount == 0){
                end --;
            }
            if(startCount == 1 && endCount == 1){
                char tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start ++;
                end --;
                startCount = 0;
                endCount = 0;
            }
        }
        return new String(arr);
    }

}
