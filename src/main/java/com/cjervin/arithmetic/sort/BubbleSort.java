package com.cjervin.arithmetic.sort;

/**
 * 冒泡排序
 *
 * @author ervin
 * @Date 2021/4/13
 */
public class BubbleSort {


    public static int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        //定义一个标志位，主要考虑到已经排好序的数组
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 6, 50, 63, 75, 10, 3, 2, 8, 7};
        System.out.println("before sort :");
        for (int a : arr) {
            System.out.println(a);
        }
        System.out.println("after sort :");
        int[] result = sort(arr);
        for (int a : result) {
            System.out.println(a);
        }
    }
}
