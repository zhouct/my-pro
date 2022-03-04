package com.zc.base.algorithms.his;

/**
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Stone {

    public static void main(String[] args) {



    }

    /**
     * 目标：凑出最接近总和一半的重量
     * dp[i][j]存储前i块石头能否凑到重量j的boolean值
     * 如果j < stone[i],则不能选择第i块石头，因为选择了必然超过j，则dp[i+1][j] = dp[i][j]
     * 如果j >= stone[i]，则有两种情况，不选择石头时dp[i+1][j] = dp[i][j]，选择石头时dp[i+1][j] = dp[i][j-stone[i]]
     *
     * @param stones
     * @return
     */
    private static int lastStone1(int[] stones){

        
        // boolean[][] dp = new boolean[]

        

        return 0;
    }

}
