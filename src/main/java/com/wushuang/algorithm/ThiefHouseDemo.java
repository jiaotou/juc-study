package com.wushuang.algorithm;

/**
 * 打家劫舍
 * 题意分析：不能偷相邻两个房间，所以当前位置可盗窃的最大值，
 * 要么就是前一个房间可盗窃的最大值，要么就是前两个房间可盗窃的最大值加上当前房间的值，
 * 两种情况取最大值即可
 * 体现到动态规划方程上就是:dp[n] = MAX(dp[n-1], dp[n-2] + num)
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/7/3 10:49
 */
public class ThiefHouseDemo {

    /**
     * 偷钱
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int dp0 = 0;
        int dp1 = 0;
        for (int i = 0; i < nums.length; i++) {
            // 计算使用 nums[i] 的情况下的最大值
            int dp2 = Math.max(dp0 + nums[i], dp1);
            // 设置新的 dp0、dp1
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
