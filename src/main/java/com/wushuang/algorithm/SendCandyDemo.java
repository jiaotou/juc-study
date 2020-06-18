package com.wushuang.algorithm;

/**
 * 分发糖果
 * 对比小朋友的评分，要么就是上升，要么下降，要么就是平行
 * 因此可以抽象出山顶和山底
 * 主要可以分为四种情况：
 * 1.左边山底到山顶的高度大，并且右边山底后继续增加
 * 2.左边山底到山顶的高度大，并且右边山底是平坡
 * 3.右边山底到山顶的高度大，并且右边山底后继续增加
 * 4.右边山底到山顶的高度大，并且右边山底是平坡
 * 因此我们用total记录糖果的总和，pre记录前一个小朋友的糖果数，如果当前的评分比前一个的评分大，
 * 那么说明在上坡，可以把前一个小朋友的糖果数加到total中，并且更新pre为当前小朋友的糖果数
 *
 * 如果当前的评分比前一个评分小，说明开始走下坡，用down变量记录连续多少次下降，
 * 此时的pre记录的就是从左边山底到山顶的高度，当出现平坡或上坡的时候，
 * 将所有的下坡的糖果数利用等差公式计算。此外根据 pre 和 down 决定山顶的糖果数。
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/6/18 15:03
 */
public class SendCandyDemo {

    /**
     * 分发糖果具体算法
     *
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        // 多少个小朋友
        int n = ratings.length;
        // 总的糖果数
        int total = 0;
        // 下坡的次数
        int down = 0;
        int pre = 1;
        for (int i = 1; i < n; i++) {
            //根据评分来判断当前是在上坡或者平坡
            if (ratings[i] >= ratings[i - 1]) {
                //如果之前出现过了下坡
                if (down > 0) {
                    //山顶的糖果数大于下降的高度，对应情况1
                    //将下降的糖果数利用等差公式计算，单独加上山顶
                    if (pre > down) {
                        total += count(down);
                        total += pre;
                        //山顶的糖果数小于下降的高度，对应情况3，
                        //将山顶也按照等差公式直接计算进去累加
                    } else {
                        total += count(down + 1);
                    }

                    //当前是上坡，对应情况1或者3
                    //更新pre等于2
                    if (ratings[i] > ratings[i - 1]) {
                        pre = 2;

                        //当前是平坡，对应情况2或者4
                        //更新pre等于1
                    } else {
                        pre = 1;
                    }
                    down = 0;
                    //之前没有出现过下坡
                } else {
                    //将前一个小朋友的糖果数相加
                    total += pre;
                    //如果是上坡更新当前糖果数是上一个的加 1
                    if (ratings[i] > ratings[i - 1]) {
                        pre = pre + 1;
                        //如果是平坡，更新当前糖果数为 1
                    } else {
                        pre = 1;
                    }
                }
            } else {
                down++;
            }
        }
        //判断是否有下坡
        if (down > 0) {
            //和之前的逻辑一样进行相加
            if (pre > down) {
                total += count(down);
                total += pre;
            } else {
                total += count(down + 1);
            }
            //将最后一个小朋友的糖果计算
        } else {
            total += pre;
        }
        return total;
    }

    /**
     * 等差数列求和
     *
     * @param n
     * @return
     */
    private static int count(int n) {
        return (1 + n) * n / 2;
    }

    public static void main(String[] args) {
        int[] ratings = {1,0,2,5,4,3,1,4};
        int count = candy(ratings);
        System.out.println(count);
    }

}
