package com.zc.base.algorithms.day;

/**
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给你一个只包含数字'0'-'9'的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 *
 * 说明：累加序列里的数 不会 以 0 开头，所以不会出现1, 2, 03 或者1, 02, 3的情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberAdd {

    /**
     * 11 23 34 57
     * 1 99 100 199 299
     * 123 237 360
     *
     * @param num
     * @return
     */
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int i = 1; i <= len/2; i++) {
            for (int j = 1; j <= len/2; j++) {
                if(valid(num, i, j)){
                    return true;
                }
            }

        }
        return false;
    }

    private boolean valid(String num, int i, int j) {
        String f = num.substring(0, i);
        String s = num.substring(i, i + j);

        if((!f.equals("0") && f.startsWith("0")) || (!s.equals("0") && s.startsWith("0"))){
            return false;
        }

        long m = Long.parseLong(f);
        long n = Long.parseLong(s);

        StringBuilder sb = new StringBuilder(f).append(s);
        if(sb.toString().equals(num)){
            return false;
        }
        while(num.startsWith(sb.toString()) && sb.length() != num.length()){
            long sum = m + n;
            m = n;
            n = sum;
            sb.append(sum);
        }

        return sb.toString().equals(num);
    }

    public static void main(String[] args) {

        NumberAdd numberAdd = new NumberAdd();

        String num = "123";

        System.out.println(numberAdd.isAdditiveNumber(num));

    }

}
