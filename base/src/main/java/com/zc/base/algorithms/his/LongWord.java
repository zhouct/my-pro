package com.zc.base.algorithms.his;

import java.util.List;

public class LongWord {

    public String findLongestWord(String s, List<String> dictionary) {
        int len = s.length();
        String tar = "";
        for (String str : dictionary) {
            int i = 0, j = 0;
            while(i < len && j < str.length()){
                if(s.charAt(i) == str.charAt(j)){
                    i ++;
                    j ++;
                }else {
                    i ++;
                }
            }
            if(j == str.length() && (str.length() > tar.length() || (str.length() == tar.length() && str.compareTo(tar) < 0))){
                tar = str;
            }
        }
        return tar;
    }

    public String findLongestWord1(String s, List<String> dictionary) {
        String regSuff = "[a-z]*";
        String tar = "";
        for (String str : dictionary) {
            int len = str.length();
            StringBuilder sbd = new StringBuilder();
            sbd.append(regSuff);
            for (int i = 0; i < len; i++) {
                sbd.append(str.charAt(i));
                sbd.append(regSuff);
            }
            String reg = sbd.toString();
            if(s.matches(reg) && (str.length() > tar.length() || (str.length() == tar.length() && str.compareTo(tar) < 0))){
                tar = str;
            }
        }
        return tar;
    }

}
