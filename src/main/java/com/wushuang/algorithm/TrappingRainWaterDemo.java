package com.wushuang.algorithm;

/**
 * 接雨水
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/6/18 20:17
 */
public class TrappingRainWaterDemo {

    public int trap(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        // 加右指针进去
        int right = height.length - 2;
        // 最前端的柱子和最后端的柱子一定没有水，因此从第二个遍历到倒数第二个
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                // 找出左边最高的柱子
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

}
