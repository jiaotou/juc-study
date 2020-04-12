package com.wushuang.algorithm;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和算法代码实现
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/9 14:03
 */
public class TwoNumsSumDemo {

    public static int[] getTwoNumsSum(int[] nums, int targets) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = targets - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("找不到结果");
    }

    public static void main(String[] args) throws IllegalArgumentException {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 9;
        int[] result = getTwoNumsSum(nums, target);
        System.out.println("" + result[0] + result[1]);
        System.out.println("" + getTwoNumsSum(nums, target));
    }
}
