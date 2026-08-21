package com.cjervin.arithmetic.test;

import java.io.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author cwj
 * @Date 2025/6/30
 */
public class Test1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {

        //写文件
        FileWriter writer = new FileWriter("");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("");

        //字符流读文件
        StringBuilder sb = new StringBuilder();
        FileReader reader = new FileReader("");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line).append("\n");
        }


        //字节流读文件
        FileInputStream fis = new FileInputStream("");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int byteRead;
        while ((byteRead = fis.read(buffer)) != -1) {
            bos.write(buffer, 0, byteRead);
        }



        String[] strArray = {"12", "34"};

        ExecutorService service = Executors.newFixedThreadPool(1);
        SubTask subTask = new SubTask(strArray);
        Future submit = service.submit(subTask);
        String result = (String)submit.get();
        System.out.println(result);
    }

}
