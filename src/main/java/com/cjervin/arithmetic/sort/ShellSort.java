package com.cjervin.arithmetic.sort;

/**
 * 希尔排序
 *
 * @author ervin
 * @Date 2021/4/13
 */
public class ShellSort {

    public static int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int step = arr.length / 2;
        for (; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;
                for (; j >= step && temp < arr[j - step]; j -= step) {
                    //符合条件往后移
                    arr[j] = arr[j - step];
                }
                arr[j] = temp;
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
