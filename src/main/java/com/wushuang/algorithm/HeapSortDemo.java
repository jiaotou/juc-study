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

    /**
     * 重新构造堆
     *
     * @param list 要排序的数组
     * @param len  数组长度
     * @param i    数组下标
     */
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

    public static void adjustHeap(int[] arr, int root, int n) {
        while (root <= n / 2) {
            int left = 2 * root;
            int right = 2 * root + 1;
            int temp;
            if (right <= n) {
                temp = arr[left] < arr[right] ? left : right;
            } else {
                temp = left;
            }
            if (arr[root] > arr[temp]) {
                swap(arr, root, temp);
                root = temp;

            } else {
                break;
            }
        }
    }

    public static void sort(int[] array) {
        int[] arr = new int[array.length + 1];
        for (int index = 1, i = 0; i < array.length; i++, index++) {
            arr[index] = array[i];
        }

        createHeap(arr);

        int count = 0;
        do {
            swap(arr, 1, arr.length - 1 - count);
            adjustHeap(arr, 1, arr.length - 2 - count);
            count++;
        } while (count <= arr.length - 1);

        for (int index = 1, i = 0; index < arr.length; i++, index++) {
            array[i] = arr[index];
        }
    }

    /**
     * adjustHeap相当于fixdown，本函数中root--相当于fixup
     * 建立完堆后，每次只需要对根进行fixdown
     *
     * @param arr
     */
    public static void createHeap(int[] arr) {
        //TODO 这里应该是length吧
        int n = arr.length - 1;
        for (int root = n / 2; root >= 1; root--) {
            adjustHeap(arr, root, n);

        }
    }

    private static void swap(int[] arr, int a, int b) {
        int aa = arr[a];
        arr[a] = arr[b];
        arr[b] = aa;
    }
}
