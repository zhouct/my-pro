package com.zc.base.algorithms.dp;

/**
 * 给定一个由整数数组 A表示的环形数组 C，求 C的非空子数组的最大可能和。
 *
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length时C[i] = A[i]，且当i >= 0时C[i+A.length] = C[i]）
 *
 * 此外，子数组最多只能包含固定缓冲区 A中的每个元素一次。（形式上，对于子数组C[i], C[i+1], ..., C[j]，不存在i <= k1, k2 <= j其中k1 % A.length= k2 % A.length）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-circular-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CircleSubArr {

    public static int maxSubarraySumCircular(int[] nums) {
        int ans = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(nums[i], 0) + nums[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public static int maxSubarraySumCircular2(int[] nums) {
        int[] nums2 = new int[nums.length * 2];
        System.arraycopy(nums, 0, nums2, 0, nums.length);
        System.arraycopy(nums, 0, nums2, nums.length, nums.length);

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(getInfo(nums2, i, i + nums.length - 1).mSum, max);
        }
        return max;
    }

    private static SubArr.Status getInfo(int[] nums2, int left, int right) {

        if(left == right){
            return new SubArr.Status(nums2[left], nums2[left], nums2[left], nums2[left]);
        }

        int m = (left + right) / 2;

        SubArr.Status lstatus = getInfo(nums2, left, m);
        SubArr.Status rstatus = getInfo(nums2, m + 1, right);

        return maxSub(lstatus, rstatus);
    }

    private static SubArr.Status maxSub(SubArr.Status lStatus, SubArr.Status rStatus) {
        SubArr.Status status = new SubArr.Status();
        status.lSum = Math.max(lStatus.lSum, lStatus.iSum + rStatus.lSum);
        status.rSum = Math.max(rStatus.rSum, rStatus.iSum + lStatus.rSum);
        status.iSum = lStatus.iSum + rStatus.iSum;
        status.mSum = Math.max(Math.max(lStatus.mSum, rStatus.mSum), lStatus.rSum + rStatus.lSum);

        return status;
    }

    public static void main(String[] args) {
        int[] nums = {5,-3,5};
        System.out.println(maxSubarraySumCircular(nums));
    }

}
