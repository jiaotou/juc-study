package com.wushuang.algorithm;

/**
 * 堆排序测试
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/4/29 14:23
 */
public class HeapSortDemo {

    public static void main(String[] args) {
        int[] nums = {16, 7, 3, 20, 17, 8};
        headSort(nums);
        for (int num : nums) {
            System.out.print(num + "");
        }
    }

    public static void headSort(int[] list) {
        //构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = (list.length) / 2 - 1; i >= 0; i--) {
            headAndSwap(list, list.length, i);
        }
        //排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = list.length - 1; i >= 1; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            headAndSwap(list, i, 0);
        }
    }

    private static void headAndSwap(int[] list, int len, int i) {
        int k = i, temp = list[i], index = 2 * k + 1;
        while (index < len) {
            if (index + 1 < len) {
                if (list[index] < list[index + 1]) {
                    index = index + 1;
                }
            }
            if (list[index] > temp) {
                list[k] = list[index];
                k = index;
                index = 2 * k + 1;
            } else {
                break;
            }
        }
        list[k] = temp;
    }
}
