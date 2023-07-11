package com.cjervin.arithmetic.arithmetic.other;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author ervin
 * @Date 2023/3/28
 */
class SequencePrint {

    private int sum = 10;
    private int num;
    private Lock lock = new ReentrantLock();

    private void print(int targetNum) {
        for (int i = 0; i < sum; ) {
            lock.lock();
            if (num % 3 == targetNum) {
                i++;
                System.out.print(i);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SequencePrint printer = new SequencePrint();
        new Thread(() -> {
            printer.print(0);
        }).start();
        new Thread(() -> {
            printer.print(1);
        }).start();
        new Thread(() -> {
            printer.print(2);
        }).start();
    }


}
