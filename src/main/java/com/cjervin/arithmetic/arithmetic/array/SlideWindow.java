package com.cjervin.arithmetic.arithmetic.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 *
 * @author ervin
 * @Date 2022/3/14
 */
public class SlideWindow {

    /**
     * 最小覆盖字串
     * 利用滑动窗口
     * <p>
     * https://leetcode-cn.com/problems/minimum-window-substring/solution/zui-xiao-fu-gai-zi-chuan-by-changxiaojie-z8mn/
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {

        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();

        for (Character c : t.toCharArray()) {
            need.put(c, need.containsKey(c) ? need.get(c) + 1 : 1);
        }
        //定义一个左开右闭区间，窗口区间
        int left = 0, right = 0;
        //valid 变量表示窗口中满足 need 条件的字符个数，如果 valid 和 need.size 的大小相同，
        // 则说明窗口已满足条件，已经完全覆盖了串 T
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        //right向右滑动
        while (right < s.length()) {
            right++;
            char c = s.charAt(right - 1);
            if (need.containsKey(c)) {
                window.put(c, window.containsKey(c) ? window.get(c) + 1 : 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //valid == need.size 说明当前窗口中已经存在覆盖字串了，接下来 left 向右滑动，寻找最小覆盖字串
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char r = s.charAt(left);
                left++;
                if (need.containsKey(r)) {
                    Integer num = window.get(r);
                    if (num.equals(need.get(r))) {
                        valid--;
                    }
                    window.put(r, num - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String window = minWindow(s, t);
        System.out.println("==");
    }
}