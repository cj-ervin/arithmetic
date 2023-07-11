package com.cjervin.arithmetic.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 抽奖 :
 * 有一个奖池，里面存放了奖励的金额：  {10，20，30，22，33，55，88，5，6，9，77，124，35，75，75，14}
 * 创建两个抽奖箱（对应两个线程） 分别为 抽奖箱1， 抽奖箱2 ，
 * 随机从奖池中获取奖项并打印，格式如下：
 * <p>
 * 抽奖箱1产生 20 元大奖
 * 抽奖箱2产生 77 元大奖
 * 抽奖箱1产生 30 元大奖
 * 抽奖箱2产生 55 元大奖
 * 抽奖箱1产生 124 元大奖
 * 抽奖箱1产生 75 元大奖
 *
 * @author ervin
 * @Date 2023/7/11
 */
public class Sweepstake {

    public static void main(String[] args) {
        int[] moneyPool = {10, 20, 30, 22, 33, 55, 88, 5, 6, 9, 77, 124, 35, 75, 75, 14, 22, 33, 55, 88, 5, 6, 9, 77, 124, 35, 75, 75, 14, 1000};
        ArrayBlockingQueue queue = new ArrayBlockingQueue<Integer>(moneyPool.length);
        for (int i = 0; i < moneyPool.length; i++) {
            queue.add(i);
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(() -> {
            while (queue.size() != 0) {
                Integer ele = (Integer) queue.poll();
                System.out.println("抽奖箱1产生大奖" + moneyPool[ele] + "元    " + Thread.currentThread().getName());
            }
        });

        threadPool.submit(() -> {
            while (queue.size() != 0) {
                Integer ele = (Integer) queue.poll();
                System.out.println("抽奖箱2产生大奖" + moneyPool[ele] + "元     " + Thread.currentThread().getName());
            }
        });


        threadPool.shutdown();
    }

}
