package com.wushuang.algorithm;

import java.util.Arrays;

/**
 * 分发饼干
 * 题意：假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，
 * 都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值
 * 分析：给一个孩子的饼干应当尽量小并且又能满足该孩子，这样大饼干才能拿来给满足度比较大的孩子。
 * 因为满足度最小的孩子最容易得到满足，所以先满足满足度最小的孩子。
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/7/3 10:32
 */
public class DistributeCookieDemo {

    /**
     * 分发饼干
     *
     * @param grid 小孩子的需求数组
     * @param size 总共拥有的饼干数组
     * @return 最大能满足的结果
     */
    public static int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) {
            return 0;
        }
        // 首先进行排序
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
        // 然后再进行遍历
        while (gi < grid.length && si < size.length) {
            // 如果小孩所需要的饼干数量小于等于我拥有的饼干数量，说明能满足
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }

}
