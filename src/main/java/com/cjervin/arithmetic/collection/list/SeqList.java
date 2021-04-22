package com.cjervin.arithmetic.collection.list;

/**
 * 顺序表实现
 *
 * @author ervin
 * @Date 2021/4/18
 */
public class SeqList<T> implements ListInterface<T> {

    //数组存放数据
    private Object[] date;

    private int length;

    public SeqList() {
        //初始大小默认为10
        init(10);
    }

    @Override
    public void init(int initSize) {
        this.date = new Object[initSize];
        length = 0;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        //是否为空
        return this.length == 0;
    }


    @Override
    public int eleIndex(T t) {
        for (int i = 0; i < date.length; i++) {
            if (date[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public T getEle(int index) throws Exception {
        if (index < 0 || index > length - 1) {
            throw new Exception("数值越界");
        }
        return (T) date[index];
    }

    @Override
    public void add(T t) throws Exception {
        //尾部插入
        add(length, t);
    }


    @Override
    public void add(int index, T t) throws Exception {
        if (index < 0 || index > length) {
            throw new Exception("数值越界");
        }
        //扩容
        if (length == date.length) {
            Object[] newDate = new Object[length * 2];
            for (int i = 0; i < length; i++) {
                newDate[i] = date[i];
            }
            date = newDate;
        }
        //后面元素后移动
        for (int i = length - 1; i >= index; i--) {
            date[i + 1] = date[i];
        }
        //插入元素
        date[index] = t;
        length++;

    }

    @Override
    public void delete(int index) throws Exception {
        if (index < 0 || index > length - 1) {
            throw new Exception("数值越界");
        }
        //index之后元素前移动
        for (int i = index; i < length; i++) {
            date[i] = date[i + 1];
        }
        length--;
    }

    @Override
    public void set(int index, T t) throws Exception {
        if (index < 0 || index > length - 1) {
            throw new Exception("数值越界");
        }
        date[index] = t;
    }
}
