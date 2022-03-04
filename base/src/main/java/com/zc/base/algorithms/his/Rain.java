package com.zc.base.algorithms.his;

public class Rain {

    public static void main(String[] args) {
        int[] height = {0,8,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    /**
     * [0,8,0,2,1,0,1,3,2,1,2,1]
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int sum = 0;
        int maxLeft = height[left];
        int maxRight = height[right];
        while (left < right){
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if(maxLeft > maxRight){
                sum += (Math.min(maxLeft, maxRight) - height[right]);
                right --;
            }else {
                sum += (Math.min(maxLeft, maxRight) - height[left]);
                left ++;
            }
        }
        return sum;
    }

    public static int trap2(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
        }
        int[] maxRight = new int[len];
        maxRight[len-1] = height[len-1];
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (Math.min(maxLeft[i], maxRight[i]) - height[i]);
        }
        return sum;
    }


}
