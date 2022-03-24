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

}
