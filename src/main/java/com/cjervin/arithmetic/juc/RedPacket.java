package com.cjervin.arithmetic.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 抢红包 题目要求：
 * <p>
 * 假设 100块钱 分成3个红包，现在有5个人去抢，其中，红包是共享数据，5个人对应5个线程
 * 要求打印结果如下：
 * <p>
 * xxx抢到了xxx元
 * xxx抢到了xxx元
 * xxx抢到了xxx元
 * xxx没抢到
 * xxx没抢到
 *
 * @author ervin
 * @Date 2023/7/11
 */
public class RedPacket {


    public static void main(String[] args) {
        //首先将红包分成三个，
        //这里偷懒了，直接手动分配
        int[] pag = {30, 30, 40};
        ArrayBlockingQueue queue = new ArrayBlockingQueue<Integer>(3);
        queue.add(pag[0]);
        queue.add(pag[1]);
        queue.add(pag[2]);

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            threadPool.submit(() -> {
                Integer poll = (Integer) queue.poll();
                if (poll == null) {
                    System.out.println("没抢到");
                } else {
                    System.out.println("抢到了" + poll + "元");
                }
            });
        }
        threadPool.shutdown();
    }

}
