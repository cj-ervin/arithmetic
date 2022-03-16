package com.cjervin.arithmetic.arithmetic.array;

/**
 * 差分数组
 * 类似前缀和技巧构造的 prefix 数组，我们先对 nums 数组构造一个 diff 差分数组，diff[i] 就是 nums[i] 和 nums[i-1] 之差
 * 差分数组的主要适用场景是频繁对原始数组的某个区间的元素进行增减
 * <p>
 * https://labuladong.gitee.io/algo/2/22/57/
 *
 * @author ervin
 * @Date 2022/3/12
 */
public class Difference {

    private int[] diff;

    /**
     * 构建差分数组
     *
     * @param nums 输入数组
     */
    public Difference(int[] nums) {
        if (nums.length >= 1) {
            diff = new int[nums.length];
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                diff[i] = nums[i] - temp;
                temp = nums[i];
            }
        }
    }

    /**
     * 给闭区间 [i,j] 增加 val（可以是负数）
     *
     * @param i   数组区间左下标
     * @param j   数组区间右下标
     * @param val 修改值
     */
    public void increment(int i, int j, int val) {
        diff[i] = diff[i] + val;
        if (j + 1 < diff.length) {
            diff[j + 1] = diff[j + 1] - val;
        }
    }

    /**
     * 将差分数组转换，返回结果数组
     *
     * @return 数组结果
     */
    public int[] result() {
        int[] arr = new int[diff.length];
        arr[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            arr[i] = diff[i] + arr[i - 1];
        }
        return arr;
    }

    /**
     * 航班预订统计 pc修改
     * <p>
     * https://leetcode-cn.com/problems/corporate-flight-bookings/solution/hang-ban-yu-ding-tong-ji-by-changxiaojie-vfcr/
     *
     * @param bookings
     * @param n
     * @return
     */
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int[] t = bookings[i];
            diff[t[0] - 1] += t[2];
            if (t[1] < diff.length) {
                diff[t[1]] -= t[2];
            }
        }
        //将差分数组转换
        int[] arr = new int[diff.length];
        arr[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            arr[i] = diff[i] + arr[i - 1];
        }
        return arr;

    }

}
