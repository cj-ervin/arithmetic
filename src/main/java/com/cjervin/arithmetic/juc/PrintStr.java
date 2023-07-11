package com.cjervin.arithmetic.juc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 打印字符串：
 * 现有三个url : www.2233.com/str/url1   www.2233.com/str/url2    www.2233.com/str/url3
 * 调用这三个url 可以分别获取相对于的三个字符串，str1  str2  str3
 * 要求使用三个线程并行调用三个url , 获取的三个字符串按顺序拼接并打印，按照 1-> 2 -> 3 的顺序拼接
 * "str1 str2 str3"
 *
 * @author ervin
 * @Date 2023/7/11
 */
public class PrintStr {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(99);
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap();
        String commonStr = "www.2233.com/str/url";
        for (int i = 1; i < 100; i++) {
            String url = commonStr + i;
            threadPool.submit(() -> {
                String resultStr = getStrByUrl(url);
                System.out.println("远程调用获取到的字符串=============="+resultStr +"================thread id == " + Thread.currentThread().getName());
                map.put(url, resultStr);
                countDownLatch.countDown();
            });
        }
        threadPool.shutdown();

        //计数器，这行代码非常重要，注释掉这行代码，运行看结果，你就知道了
        countDownLatch.await();

        System.out.println("开始拼接字符串======================================");
        StringBuilder sb = new StringBuilder();
        for (int e = 1; e < 100; e++) {
            String url = commonStr + e;
            sb.append(map.get(url)).append(System.getProperty("line.separator"));
        }
        System.out.println(sb.toString());
    }


    /**
     * 模拟调用，获取字符串
     *
     * @param url
     * @return
     */
    private static String getStrByUrl(String url) {
        return "str" + url.substring(20);
    }
}
