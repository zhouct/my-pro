package com.zc.base.algorithms.dp;

public class Jump {

    public static boolean canJump1(int[] nums) {

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(max >= i){
                max = Math.max(max, i + nums[i]);
            }
        }

        return max >= nums.length - 1;
    }

    /**
     * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     *
     * 假设你总是可以到达数组的最后一个位置。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * [6,4,4,3,2,5,1,1,1,1,3]
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i ++) {
            for (int j = i; j <= (i - 1 + nums[i-1]) && j < nums.length; j++) {
                if(dp[j] > 0){
                    dp[j] = Math.min(dp[i-1] + 1, dp[j]);
                }else {
                    dp[j] = dp[i-1] + 1;
                }
            }
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {

        int[] nums = {2,3,0,1,4};

        System.out.println(jump(nums));

    }

}
