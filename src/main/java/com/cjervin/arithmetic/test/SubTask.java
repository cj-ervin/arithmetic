package com.cjervin.arithmetic.test;

import java.util.concurrent.Callable;

/**
 * @Author cwj
 * @Date 2025/6/30
 */
public class SubTask implements Callable {


    private String[] strArray;

    public SubTask(String[] strArray) {
        this.strArray = strArray;
    }

    @Override
    public Object call() throws Exception {
        return strArray[0] + strArray[1];
    }
}
