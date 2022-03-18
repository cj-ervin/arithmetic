package com.cjervin.arithmetic.arithmetic.structure;

import java.util.LinkedHashMap;

/**
 * LRU 算法实现
 * 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * 哈希表查找快，但是数据无固定顺序；链表有顺序之分，插入删除快，但是查找慢。所以结合一下，形成一种新的数据结构：哈希链表 LinkedHashMap。
 * <p>
 * https://leetcode-cn.com/problems/lru-cache/solution/lru-huan-cun-by-changxiaojie-tibx/
 *
 * @author ervin
 * @Date 2022/3/18
 */
public class LRUCache {

    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap();

    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            //将其放到尾部
            makeRecent(key);
            return cache.get(key);
        }
        return -1;
    }


    public void put(int key, int value) {
        //如果存在的话，修改该key的value值，并将其将其放到尾部
        if (cache.containsKey(key)) {
            makeRecent(key);
            cache.put(key, value);
            return;
        }
        //如果不存在的话，判断是否超过cap容量限制，
        //如果没有超过容量限制，直接put到队尾.
        //如果超过了容量限制，删除队头一个元素，put新元素到队尾
        if (cache.size() >= this.cap) {
            int firstNode = cache.keySet().iterator().next();
            cache.remove(firstNode);
        }
        cache.put(key, value);

    }

    /**
     * 将某个键值对放到尾部，（尾部都是最新使用的）
     *
     * @param key
     */
    private void makeRecent(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }

}
