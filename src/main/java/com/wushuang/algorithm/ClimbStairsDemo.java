package com.wushuang.algorithm;

/**
 * 爬楼梯
 * 解题思路：就是一个斐波拉契数列
 * 动态规划
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/6/19 16:08
 */
public class ClimbStairsDemo {

    /**
     * 第一种递归解法,如果n值过大，会超时
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 非递归算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    /**
     * 非递归算法2 优化
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        int first = 1;
        int second = 2;
        int sum = 0;
        while (n-- > 2) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(4));
        System.out.println(climbStairs2(4));
    }
}
