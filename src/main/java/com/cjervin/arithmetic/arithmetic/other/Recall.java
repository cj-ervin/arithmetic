package com.cjervin.arithmetic.arithmetic.other;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法
 *
 * @author ervin
 * @Date 2022/3/24
 */
public class Recall {

    List<List<Integer>> res = new LinkedList<>();

    /**
     * 全排列
     * <p>
     * https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-changxiaojie-nw98/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        doPermute(track, nums, used);
        return res;
    }


    /**
     * @param trace 路径：记录在 track 中
     * @param nums  选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
     * @param used  结束条件：nums 中的元素全都在 track 中出现
     */
    private void doPermute(LinkedList<Integer> trace, int[] nums, boolean[] used) {
        if (trace.size() == nums.length) {
            res.add(new LinkedList<>(trace));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //校验是否已经走过该路径，走过直接忽略
            if (used[i]) {
                continue;
            }
            //选择路径
            trace.add(nums[i]);
            used[i] = true;
            doPermute(trace, nums, used);
            //取消选择
            trace.removeLast();
            used[i] = false;
        }

    }


    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    /**
     * 子集
     * <p>
     * https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-changxiaojie-idd4/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    /**
     * 回溯算法核心函数，遍历子集问题的回溯树
     *
     * @param nums
     * @param start
     */
    void backtrack(int[] nums, int start) {

        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));

        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }


    /**
     * 划分为k个相等的子集
     * <p>
     * https://labuladong.gitee.io/algo/4/30/107/
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除一些基本情况
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int v : nums) {
            sum += v;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        int[] bucket = new int[k];
        return checkPartition(nums, bucket, 0, target);
    }

    private boolean checkPartition(int[] nums, int[] bucket, int index, int target) {
        if (index > nums.length - 1) {
            for (int i : bucket) {
                if (i != target) {
                    return false;
                }
            }
            return true;
        }
        //穷举 num[index] 的所有情况
        for (int i = 0; i < bucket.length; i++) {
            //剪枝
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            bucket[i] += nums[index];
            if (checkPartition(nums, bucket, index + 1, target)) {
                return true;
            }
            bucket[i] -= nums[index];
        }
        return false;
    }

}
