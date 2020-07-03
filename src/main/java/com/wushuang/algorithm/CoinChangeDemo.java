package com.wushuang.algorithm;

import java.util.Arrays;

/**
 * 零钱兑换
 * 分析：动态规划
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/7/3 18:05
 */
public class CoinChangeDemo {
    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        // 维护一个动态规划数组
        int[] dp = new int[amount + 1];
        // 先初始化数组
        Arrays.fill(dp, max);
        dp[0] = 0;
        // 遍历获得子集的解
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public int coinChangeDfs(int[] coins, int amount) {
        // 首先硬币排序
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * 深度搜索算法
     * 详解：DFS 搜索顺序为面值从大到小，同一面值数量由多到少，搜索过程中记录到此为止所花费的硬币数。
     * <p>
     * 剪枝处理如下，具体位置见代码注释：
     * <p>
     * 当 amount==0 时剪枝，因为大面值硬币需要更多小面值硬币替换，继续减少一枚或几枚大硬币搜索出来的答案【如果有】肯定不会更优。
     * 当 amount!=0，但已经使用的硬币数 cnt 满足了 cnt+1>=ans 时剪枝，因 amount 不为 0，至少还要使用 1 枚硬币，
     * 则继续搜索得到的答案不会更优。是 break 不是 continue，
     * 因为少用几枚面值大的硬币搜索出的方案【如果有】肯定需要更多枚面值小的硬币来替换掉这枚大的硬币【同剪枝 1 理由】，
     * 而使用这几枚大的硬币都搜索不到更好的解，故应该是 break。
     *
     * @param coins  硬币集合
     * @param index  硬币集合长度
     * @param amount 目标金额
     * @param cnt    所需要硬币的个数
     */
    public void dfs(int[] coins, int index, int amount, int cnt) {
        if (index < 0) {
            return;
        }
        for (int c = amount / coins[index]; c >= 0; c--) {
            int na = amount - c * coins[index];
            int ncnt = cnt + c;
            if (na == 0) {
                ans = Math.min(ans, ncnt);
                break;//剪枝1
            }
            if (ncnt + 1 >= ans) {
                break; //剪枝2
            }
            dfs(coins, index - 1, na, ncnt);
        }
    }

}
