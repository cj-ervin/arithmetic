package com.cjervin.arithmetic.arithmetic.array;

/**
 * 一维数组中的前缀和
 * 核心思路是我们 new 一个新的数组 preSum 出来，preSum[i] 记录 nums[0..i-1] 的累加和
 * <p>
 * https://leetcode-cn.com/problems/range-sum-query-immutable/solution/by-changxiaojie-zxq0/
 *
 * @author ervin
 * @Date 2022/3/11
 */
public class NumArray {

    private int[] preNums;

    /**
     * 数组初始化
     *
     * @param nums 数组
     */
    public NumArray(int[] nums) {
        preNums = new int[nums.length + 1];
        for (int i = 1; i < preNums.length; i++) {
            preNums[i] = preNums[i - 1] + nums[i - 1];
        }
    }


    /**
     * 查询闭区间 [left, right] 的累加和
     *
     * @param left  索引
     * @param right 索引
     * @return result
     */
    public int sumRange(int left, int right) {
        return preNums[right + 1] - preNums[left];
    }

}
