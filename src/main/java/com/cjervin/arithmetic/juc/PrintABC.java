package com.cjervin.arithmetic.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串
 * <p>
 * 其他多个不同解法 ：  https://blog.51cto.com/wangshiyu/2931487
 *
 * @author ervin
 * @Date 2023/7/11
 */
public class PrintABC {


    private static Semaphore semaphore1 = new Semaphore(1); //// 只有A 初始信号量为1,第一次获取到的只能是A
    private static Semaphore semaphore2 = new Semaphore(0);
    private static Semaphore semaphore3 = new Semaphore(0);

    private static int times = 2;

    private static void printS(String el, Semaphore current, Semaphore next) throws InterruptedException {

        for (int i = 0; i < times; i++) {
            current.acquire();
            System.out.println(el);
            next.release();
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> {
            try {
                printS("A", semaphore1, semaphore2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        executorService.submit(() -> {
            try {
                printS("B", semaphore2, semaphore3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                printS("C", semaphore3, semaphore1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }

}
