package com.zc.base.algorithms.dp;


import java.util.*;

/**
 * 给你一个整数数组nums，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Earn {

    public static int deleteAndEarn(int[] nums) {

        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num, num + map.get(num));
            }else {
                map.put(num, num);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        int[] dp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if(i == 0){
                dp[0] = map.get(list.get(0));
            }else if(i == 1){
                if(list.get(1) - list.get(0) > 1){
                    dp[1] = map.get(list.get(0)) + map.get(list.get(1));
                }else {
                    dp[1] = Math.max(map.get(list.get(0)), map.get(list.get(1)));
                }
            }else {
                if(list.get(i) - list.get(i-1) > 1){
                    dp[i] = Math.max(dp[i-1] + map.get(list.get(i)), dp[i-2] + map.get(list.get(i)));
                }else {
                    dp[i] = Math.max(dp[i-1], dp[i-2] + map.get(list.get(i)));
                }
            }
        }
        return dp[map.size() - 1];
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,4,5,5,5,6};

        System.out.println(deleteAndEarn(nums));

    }

}
