package com.cjervin.arithmetic.sort;

/**
 * 选择排序
 *
 * @author ervin
 * @Date 2021/4/13
 */
public class SelectionSort {

    public static int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
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
