package com.zc.base.algorithms.his;

public class Encode {


    /**
     * dp[0] = count(s[0]);
     * dp[1] = dp[i-1] * count(s[i]) + count(s[i-1,i]);
     * dp[i] = dp[i-1] * count(s[i]) + dp[i-2] * count(s[i-1,i])
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if(i == 0){
                dp[i] = count(s.charAt(i));
            }else if(i == 1){
                dp[i] = dp[i-1] * count(s.charAt(i)) + count(s.charAt(i-1), s.charAt(i));
            }else {
                dp[i] = dp[i-1] * count(s.charAt(i)) + dp[i-2] * count(s.charAt(i-1), s.charAt(i));
            }
        }
        return dp[s.length()-1];
    }

    private int count(char c1, char c2) {
        if(c1 == '*'){
            if(c2 == '*'){
                return 15;
            }else if(c2 <= '6'){
                return 2;
            }else {
                return 1;
            }
        }else if(c1 == '1'){
            if(c2 == '*'){
                return 9;
            }else {
                return 1;
            }
        }else if(c1 == '2'){
            if(c2 == '*'){
                return 6;
            }else if(c2 <= '6'){
                return 1;
            }else {
                return 0;
            }
        }else{
            return 0;
        }
    }

    private int count(char c) {
        if(c == '*'){
            return  9;
        }else if(c == '0'){
            return  0;
        }else {
            return  1;
        }
    }

}
