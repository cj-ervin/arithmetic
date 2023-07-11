package com.cjervin.arithmetic.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 卖电影票：
 * 现有 1000 张电影票， 可以在两个窗口领取，
 * 要求使用多线程模拟买票的情况，并打印剩余的电影票的数量
 *
 * @author ervin
 * @Date 2023/7/11
 */
public class CinemaTicket {


    private static AtomicInteger ticketNum = new AtomicInteger(100);


    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 2; i++) {
            threadPool.submit(() -> {
                while (0 < ticketNum.get()) {
                    int residue = ticketNum.getAndDecrement();
                    System.out.println("还剩余=========" + residue + "===张票=======当前窗口线程 ======" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        System.out.println("三个线程执行完毕，剩余票数：==========" + ticketNum.get());
        threadPool.shutdown();
    }
}
