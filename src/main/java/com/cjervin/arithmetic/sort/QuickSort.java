package com.cjervin.arithmetic.sort;

/**
 * 快速排序
 *
 * @author ervin
 * @Date 2021/4/17
 */
public class QuickSort {

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

    public static int[] sort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //分区
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = left;
        //指针 j
        int j = pivot + 1;
        for (int i = j; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, j);
                j++;
            }
        }
        swap(arr, pivot, j - 1);
        return j - 1;

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
