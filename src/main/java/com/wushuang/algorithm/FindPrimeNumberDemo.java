package com.wushuang.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出素数
 * 寻找小于N的素数
 * 解题思路：暴力法
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/6/19 9:52
 */
public class FindPrimeNumberDemo {

    public static List<Integer> findPrime(int n) {
        List<Integer> res = new ArrayList<>();
        boolean isSuShu;
        long time = System.currentTimeMillis();
        for (int i = 2; i <= n; i++) {
            int j = 2;
            isSuShu = true;
            while (j <= Math.sqrt(i)) {
                if (i % j == 0) {
                    isSuShu = false;
                    break;
                }
                j++;
            }
            if (isSuShu) {
                res.add(i);
            }
        }
        System.out.println("用时为" + (System.currentTimeMillis() - time));
        return res;
    }

    /**
     * 统计N之内有多少个素数
     *
     * @param n 目标值
     * @return 结果值
     */
    public static int countPrime(int n) {
        // 创建一个数组来存放是否是素数
        boolean[] isPrim = new boolean[n];
        // 首先将所有的数都默认为素数压入数组
        Arrays.fill(isPrim, true);
        // 然后从2开始遍历，遍历到sqrt(n)
        for (int i = 2; i * i < n; i++) {
            // 判断如果是素数,那么将当前素数的倍数设置为非素数
            if (isPrim[i]) {
                // 将当前素数的倍数设置为非素数
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findPrime(100));
        System.out.println(countPrime(100));
    }
}
