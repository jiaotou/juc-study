package com.wushuang.algorithm;

/**
 * 高楼扔鸡蛋
 * 分析：不论是动态规划还是递归，都是将求N层楼扔多少次的问题转化为扔多少次可以覆盖N层楼，这样就省去了二分法等过程。
 * 两种方法都涉及到转化公式：dp(K, T) = dp(K - 1, T - 1) + dp(K, T - 1) + 1，其中K为鸡蛋数，T为扔的次数。
 * 例如在第X层扔一个鸡蛋，则剩余测试次数为T-1，如果碎了，则向低于X的楼层覆盖。剩余鸡蛋数为K - 1，即覆盖范围为dp(K - 1, T - 1)。
 * 同理，如果不碎，则向高于X的楼层覆盖，其覆盖范围为dp(K, T - 1)。
 * 再加上第X层，总覆盖范围即为dp(K, T) = dp(K - 1, T - 1) + dp(K, T - 1) + 1。
 * 当T为1时，只能覆盖到第1层，当K为1时，则能测试多少次，就能覆盖到多少层，即可以覆盖到第T层。
 * 当最终覆盖范围大于等于N时，则对应的操作次数即为最终答案。
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/7/3 17:16
 */
public class SuperEggDropDemo {

    /**
     * 递归算法扔鸡蛋
     *
     * @param K 鸡蛋个数
     * @param N 高楼层数
     * @return
     */
    public static int superEggDrop(int K, int N) {
        int t = 1;
        while (coverN(K, t) < N) {
            t++;
        }
        return t;
    }

    public static int coverN(int K, int t) {
        if (K == 1 || t == 1) {
            return t;
        }
        return coverN(K - 1, t - 1) + coverN(K, t - 1) + 1;
    }

    /**
     * 动态规划算法扔鸡蛋
     *
     * @param K 鸡蛋个数
     * @param N 高楼层数
     * @return
     */
    public static int superEggDropByDp(int K, int N) {
        int[] dp = new int[K + 1];
        int ans = 0;
        while (dp[K] < N) {
            for (int i = K; i > 0; i--) {
                dp[i] = dp[i] + dp[i - 1] + 1;
            }
            ans++;
        }
        return ans;
    }

}
