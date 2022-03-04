package com.zc.base.algorithms.day;

public class Triplet {

    /**
     * [2,1,5,0,1,2,1,2,3]
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int m = nums[0], n = nums[0];
        int len = nums.length;
        boolean flag = false;
        for (int i = 1; i < len; i++) {
            if(nums[i] <= m){
                m = nums[i];
            }else {
                if(!flag){
                    n = nums[i];
                }else {
                    if(nums[i] < n){
                        n = nums[i];
                    }else if(nums[i] > n){
                        return true;
                    }
                }
                flag = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Triplet triplet = new Triplet();

        int[] nums = {20,100,10,12,5,13};

        System.out.println(triplet.increasingTriplet(nums));
    }

}
