package com.wushuang.algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TOP N算法题实现：指的是从已经存在的数组中，找出最大（或最小）的前n个元素
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/15 14:17
 */
public class TopNAlgorithmDemo {

    public static int[] datas = new int[100000000];

    /**
     * 生成测试数据
     */
    public static void generateData()
    {
        Random random = new Random(System.currentTimeMillis());

        for (int i=0; i < datas.length; i++)
        {

            datas[i] = random.nextInt(1000000000);
        }
    }

    /**
     * main 方法
     * @param args
     */
    public static void main(String[] args) {
        int topN = 100;
        Integer[] topNData = new Integer[topN];

        System.out.println("Start generateData Data.");
        TopNAlgorithmDemo.generateData();
        System.out.println("End genarate Data.");

        // 初始化 Top N
        for (int i = 0; i < topN; i++) {
            topNData[i] = 0;
        }

        System.out.println("Search for top N Starting.");

        // 获取TopN
        for (int i = 0; i < datas.length; i++) {
            int num = datas[i];

            if (num % 1000000 == 0) {
                System.out.println("Search for top N index:" + i);
            }

            if (topNData[0] < num) {
                topNData[0] = num;

                // 使用折半插入排序
                Collections.sort(Arrays.asList(topNData));
            }
        }

        for (int i = 0; i < topNData.length; i++) {
            System.out.println("Top N:" + topNData[i]);
        }

        System.out.println("Search for top N ended.");


    }

}
