package com.cjervin.arithmetic.sort;

/**
 * 插入排序
 *
 * @author ervin
 * @Date 2021/4/13
 */
public class InsertionSort {

    public static int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            for (; j > 0; j--) {
                if (temp < arr[j - 1]) {
                    //符合条件往后挪
                    arr[j] = arr[j - 1];
                } else {
                    //此处break不能省略，用来停止 j 的自减
                    break;
                }
            }
            arr[j] = temp;
        }
        return arr;
    }

    public static int[] sort1(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            for (; j > 0 && temp < arr[j - 1]; j--) {
                //符合条件往后挪
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
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
        int[] result = sort1(arr);
        for (int a : result) {
            System.out.println(a);
        }
    }

}
