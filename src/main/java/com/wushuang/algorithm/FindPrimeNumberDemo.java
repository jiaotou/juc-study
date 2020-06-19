package com.wushuang.algorithm;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        System.out.println(findPrime(10000));
    }
}
