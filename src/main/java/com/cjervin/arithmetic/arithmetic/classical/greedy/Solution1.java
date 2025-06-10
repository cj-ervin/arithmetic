package com.cjervin.arithmetic.arithmetic.classical.greedy;

import java.util.Arrays;

/**
 * 贪心算法例子
 *
 * @Author cwj
 * @Date 2025/2/7
 */
public class Solution1 {

    /**
     * 455. 分发饼干 https://leetcode.cn/problems/assign-cookies/description/
     *
     * @param g 小孩
     * @param s 饼干
     * @return 可以满足的数量
     */
    public int findContentChildren(int[] g, int[] s) {

        //想一想，尺寸最小的饼干，应该给哪个孩子？
        //
        //如果这个饼干的尺寸 x 比最小的 g[i] 还小，那么无法给任何孩子。
        //否则，这个饼干应该给最小的 g[i]。如果不给，那万一只有这个孩子胃口小，其他孩子胃口大，我们就浪费了一次分发饼干的机会。或者说，我们相当于在孩子和饼干之间找到一个最优匹配，如果出现 x 匹配胃口大的孩子，另一个比 x 更大的尺寸 y 匹配胃口最小的孩子，那么交换这两个匹配，匹配仍然是成立的，所以总是可以使 x 匹配胃口最小的孩子。
        //发完这个饼干后，继续考虑尺寸次小的饼干，思考方式同上。
        //算法
        //把 g 和 s 从小到大排序。
        //遍历饼干大小 s。同时维护另一个指针 i=0 表示胃口。
        //设 g 的长度为 n，如果 i<n 且 g[i]≤x，那么把饼干分给这个孩子，i 增加 1。
        //i 增加的次数就是得到饼干的孩子个数，所以最后返回 i。
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int k : s) {
            if (i < g.length && g[i] <= k) {
                i++;
            }
        }
        return i;

    }

    /**
     * 121. 买卖股票的最佳时机 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
     *
     * @param prices 每天的股票价格
     * @return 计算出的能获取的最大利润
     */

    public int maxProfit(int[] prices) {
        int profit = 0;
        int cost = Integer.MAX_VALUE;
        for (int p : prices) {
            cost = Math.min(cost, p);
            profit = Math.max(profit, p - cost);
        }
        return profit;
    }


    /**
     * 122. 买卖股票的最佳时机 II https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
     * @param prices
     * @return
     */
//    public int maxProfit2(int[] prices) {
//        int profit = 0, cost = Integer.MAX_VALUE;
//        int total = 0;
//
//        for (int p : prices) {
//
//        }
//    }
}
