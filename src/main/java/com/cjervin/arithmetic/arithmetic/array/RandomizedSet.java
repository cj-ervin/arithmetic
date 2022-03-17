package com.cjervin.arithmetic.arithmetic.array;

import java.util.*;

/**
 * O(1) 时间插入、删除和获取数组随机元素
 * <p>
 * hhttps://leetcode-cn.com/problems/insert-delete-getrandom-o1/solution/o1-shi-jian-cha-ru-shan-chu-he-huo-qu-sh-nkz4/
 *
 * @author ervin
 * @Date 2022/3/17
 */
public class RandomizedSet {

    Map<Integer, Integer> dict;
    List<Integer> arr;
    Random rand = new Random();

    public RandomizedSet() {
        this.dict = new HashMap<>();
        this.arr = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }
        dict.put(val, arr.size());
        arr.add(arr.size(), val);
        return true;
    }

    /**
     * 如果我们想在 O(1) 的时间删除数组中的某一个元素 val，
     * 可以先把这个元素交换到数组的尾部，然后再 pop 掉。
     * <p>
     * 对数组尾部进行插入和删除操作不会涉及数据搬移，时间复杂度是 O(1)。
     *
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if (!dict.containsKey(val)) {
            return false;
        }
        Integer lastElement = arr.get(arr.size() - 1);
        Integer index = dict.get(val);
        arr.set(index, lastElement);
        dict.put(lastElement, index);
        arr.remove(arr.size() - 1);
        dict.remove(val);
        return true;
    }

    public int getRandom() {

        return arr.get(rand.nextInt(arr.size()));
    }
}
