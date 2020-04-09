package com.wushuang.algorithm;

/**
 * 股票最大利润算法代码实现
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/9 13:46
 */
public class StockMaxProfitDemo {

    private static int getMaxProfit(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return 0;
        }
        int minPrice = arr[0];
        int maxProfit = arr[1] - minPrice;
        for (int i = 2; i < len; i++) {
            if (minPrice > arr[i - 1]) {
                minPrice = arr[i - 1];
            }
            int currentDiff = arr[i] - minPrice;
            if (currentDiff > maxProfit) {
                maxProfit = currentDiff;
            }
        }
        return maxProfit;
    }

    public static int maxProfitMuli(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < len - 1; i++) {
            //贪心法
            int profit = arr[i + 1] - arr[i];
            if (profit > 0) {
                maxProfit += profit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {9, 11, 8, 5, 7, 12, 16, 14};
        int result = getMaxProfit(arr);
        System.out.println("最大收益为" + result);
        int result1 = maxProfitMuli(arr);
        System.out.println("多次交易最大收益为:" + result1);
    }
}
