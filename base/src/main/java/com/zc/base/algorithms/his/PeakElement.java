package com.zc.base.algorithms.his;

public class PeakElement {

    public static void main(String[] args) {
        PeakElement peakElement = new PeakElement();
        int[] nums = {1,2,3,4,3,2};
        System.out.println(peakElement.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }

    public int findPeakElement(int[] nums, int left, int right){
        if(right - left < 5){
            for (int i = left + 1; i <= right - 1; i++) {
                if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                    return i;
                }
            }
            if(left == right){
                return left;
            }
            if(left == 0 && nums[left] > nums[left + 1]){
                return 0;
            }
            if(right == nums.length - 1 && nums[right] > nums[right - 1]){
                return right;
            }
            return -1;
        }else {
            int mid = (left + right) / 2;
            for (int i = mid - 1; i <= mid + 1; i++) {
                if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                    return i;
                }
            }
            int leftResult = findPeakElement(nums, left, mid - 1);
            return leftResult != -1? leftResult : findPeakElement(nums, mid + 1, right);
        }
    }

}
