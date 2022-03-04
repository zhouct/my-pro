package com.zc.base.algorithms.dp;


public class Rob {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * dp[i] = Math.max(dp[i-1], dp[i-2] + i)
     */
    public static int rob1(int[] nums) {

        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                dp[0] = nums[0];
            }else if(i == 1){
                dp[1] = Math.max(nums[0], nums[1]);
            }else {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
        }

        return dp[nums.length - 1];
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
     * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {

        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if(i == 0){
                dp[0] = nums[0];
            }else if(i == 1){
                dp[1] = Math.max(nums[0], nums[1]);
            }else {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
        }
        int max;
        if(nums.length == 1){
            max = nums[0];
        }else {
            max = dp[nums.length - 2];
        }

        for (int i = 1; i < nums.length; i++) {
            if(i == 1){
                dp[1] = nums[1];
            }else if(i == 2){
                dp[2] = Math.max(nums[1], nums[2]);
            }else {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
        }
        max = Math.max(max, dp[nums.length-1]);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob2(nums));
    }

}
