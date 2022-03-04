package com.zc.base.algorithms.str;

public class Vps {

    public static int maxDepth(String s) {
        int count = 0;
        int dep = 0;
        for(int i = 0; i < s.length(); i ++){
            if('(' == s.charAt(i)){
                count ++;
                dep = Math.max(count, dep);
            }else if(')' == s.charAt(i)){
                count --;
            }
        }
        return dep;
    }

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }

}
