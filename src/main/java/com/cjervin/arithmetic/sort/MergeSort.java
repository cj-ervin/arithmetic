package com.cjervin.arithmetic.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author ervin
 * @Date 2021/4/17
 */
public class MergeSort {


    public static int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        //递归调用
        return merge(sort(left), sort((right)));
    }

    private static int[] merge(int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int[] result = new int[leftLength + rightLength];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] > right[0]) {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            } else {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            }
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        return result;
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
