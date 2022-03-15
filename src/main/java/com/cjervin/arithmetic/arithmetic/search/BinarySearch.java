package com.cjervin.arithmetic.arithmetic.search;

/**
 * 二分查找
 *
 * @author ervin
 * @Date 2022/3/15
 */
public class BinarySearch {

    /**
     * 简单的二分查找
     * <p>
     * https://leetcode-cn.com/problems/binary-search/solution/er-fen-cha-zhao-by-changxiaojie-jikl/
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;

    }
}
