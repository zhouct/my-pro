package com.zc.base.algorithms.his;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseStr {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }

    public static String reverseStr(String s, int k) {
        int len = s.length();
        if(len <= k){
            char[] chars = s.toCharArray();
            for(int i = 0, j = len - 1; i < j ; i ++, j --){
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
            return new String(chars);
        }else if(len > k && len <= 2 * k){
            return reverseStr(s.substring(0, k), k) + s.substring(k, len);
        }else {
            return reverseStr(s.substring(0, 2 * k), k) + reverseStr(s.substring(2*k, len), k);
        }
    }

}
