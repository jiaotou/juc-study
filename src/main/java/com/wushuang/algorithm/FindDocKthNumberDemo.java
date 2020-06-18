package com.wushuang.algorithm;

/**
 * 查找字典序的第K小数字
 * 首先弄懂什么是字典序，字典序就是根据数字的前缀从小到大进行排序，
 * 所以字典序的排序就是针对十叉数进行先序遍历
 * 题目的意思就是找到排在第K位的数
 * 因此我们要搞清楚几件事：怎么确定一个前缀下面所有子节点的个数，如果K个数在当前前缀下，怎么继续往下面的子节点找
 * 如果不在，那么如何扩大前缀，增大寻找的范围
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/6/17 15:53
 */
public class FindDocKthNumberDemo {

    public static int findKthNumber(int n, int k) {
        //第一字典序小的(就是1)
        int curr = 1;

        k = k - 1;
        while (k > 0) {
            // 计算前缀之间的step数
            int steps = getSteps(n, curr, curr + 1);
            // 前缀间距太大，需要深入一层
            if (steps > k) {
                curr *= 10;
                // 多了一个确定节点，继续-1
                k -= 1;
            }
            // 间距太小，需要扩大前缀范围
            else {
                curr += 1;
                k -= steps;
            }
        }
        return curr;
    }

    private static int getSteps(int n, long curr, long next) {
        int steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }

    public static void main(String[] args) {
        int n = 112;
        int k = 5;
        System.out.println(findKthNumber(n, k));
    }
}
