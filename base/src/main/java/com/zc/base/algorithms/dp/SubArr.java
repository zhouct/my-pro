package com.zc.base.algorithms.dp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class SubArr {

    /**
     * {-5,9,1,-5,-6,4,2}
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;

        int[][] dp = new int[len][len];
        int max = nums[0];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(j == i){
                    dp[i][j] = nums[i];
                }else{
                    dp[i][j] = dp[i][j-1] + nums[j];
                }
                if(max < dp[i][j]){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

    /**
     * {-5,9,1,-5,-6,4,2}
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if(dp[i-1] < 0){
                dp[i] = nums[i];
            }else {
                dp[i] = dp[i-1] + nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            if(sum < 0){
                max = Math.max(sum, max);
                sum = 0;
            }else {
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    /**
     * 分治
     * @param nums
     * @return
     */
    public int maxSubArray4(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    private Status getInfo(int[] nums, int left, int right){
        if(left == right){
            return new Status(nums[left], nums[left], nums[left], nums[left]);
        }

        int m = (left + right) / 2;
        Status lStatus = getInfo(nums, left, m);
        Status rStatus = getInfo(nums, m + 1, right);

        return findMaxSub(lStatus, rStatus);
    }

    private Status findMaxSub(Status lStatus, Status rStatus) {

        Status status = new Status();
        status.lSum = Math.max(lStatus.lSum, lStatus.iSum + rStatus.lSum);
        status.rSum = Math.max(rStatus.rSum, rStatus.iSum + lStatus.rSum);
        status.iSum = lStatus.iSum + rStatus.iSum;
        status.mSum = Math.max(Math.max(lStatus.mSum, rStatus.mSum), lStatus.rSum + rStatus.lSum);

        return status;
    }

    /**
     * 区间[l,r]
     */
    public static class Status{

        int lSum;  // 包含左边界的最大子序和

        int rSum;  // 包含右边界的最大子序和

        int mSum;  // 最大子序和

        int iSum;  // 区间和

        public Status(int lSum, int rSum, int mSum, int iSum){
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }

        public Status(){

        }

    }

    public static void main(String[] args) {
        SubArr subArr = new SubArr();
        int[] arr = {8,1,-5,-3,4,5};
        System.out.println(subArr.maxSubArray4(arr));
    }

}
