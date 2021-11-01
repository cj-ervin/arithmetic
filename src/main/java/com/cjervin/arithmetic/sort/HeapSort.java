package com.cjervin.arithmetic.sort;

/**
 * 堆排序
 *
 * @author ervin
 * @date 2021/10/29 15:05
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {5, 8, 9, 3, 7, 2, 6, 1, 21, 4};
        sort(arr);
        System.out.println("==========");
        for (int a : arr) {
            System.out.println(a);
            ;
        }
    }

    public static void sort(int[] arr) {
        //首先构建大堆顶
        int size = arr.length;
        int maxIndex = size - 1;
        //从下到上 从右到左
        for (int i = (size / 2) - 1; i >= 0; i--) {
            if (2 * (i + 1) < maxIndex) {
                int index = arr[2 * (i + 1)] > arr[2 * (i + 1) - 1] ? 2 * (i + 1) : 2 * (i + 1) - 1;
                if (arr[index] > arr[i]) {
                    swap(arr, index, i);
                }
            } else {
                if (arr[2 * (i + 1) - 1] > arr[i]) {
                    swap(arr, 2 * (i + 1) - 1, i);
                }
            }
        }
        for (int a : arr) {
            System.out.println(a);

        }
        //进行n-1次循环
        for (int i = 0; i < size - 1; i++) {
            //首尾交换
            swap(arr, 0, size - 1 - i);
            //交换之后再次构建
            for (int j = 0; j < (size - 2 - i) / 2; j++) {
                if (2 * (j + 1) <= size - 2 - i) {
                    int index = arr[2 * (j + 1)] > arr[2 * (j + 1) - 1] ? 2 * (j + 1) : 2 * (j + 1) - 1;
                    if (arr[index] > arr[j]) {
                        swap(arr, index, j);
                    }
                } else {
                    if (arr[2 * (j + 1)] > arr[j]) {
                        swap(arr, 2 * (j + 1), j);
                    }
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
